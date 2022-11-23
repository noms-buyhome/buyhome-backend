package com.ssafy.buyhome.user.model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.buyhome.user.model.dao.UserDao;
import com.ssafy.buyhome.user.model.dto.Token;
import com.ssafy.buyhome.user.model.dto.User;
import com.ssafy.buyhome.util.ParameterStringBuilder;
import com.ssafy.buyhome.util.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class KakaoAuthService implements AuthService {

    private static final String REQUEST_URL = "https://kauth.kakao.com/oauth/token";
    private static final String API_KEY = "f427e8067a6aef6575b4e51dd60be434";
    private static final String REDIRECTED_URL = "http://localhost:8080/api/auth/login?type=kakao";
    private static final String CLIENT_SECRET = "4evW0M6AzlFNG3ZzqfZourQYivYTCntS";
    private final TokenProvider tokenProvider;
    private final UserDao userDao;

    @Override
    public Token login(String username, String password) {
        throw new RuntimeException();
    }

    @Override
    public Token login(String code) {
        Map<String, String> kakaoToken = getKakaoToken(code);
        User user = getUser(kakaoToken);
        return tokenProvider.createToken(user.getUsername(), user.getAuthority());
    }

    @Override
    public void register(User user) {
        userDao.insert(user);
    }

    private Map<String, String> getKakaoToken(String code) {
        Map<String, String> response = null;
        try {
            URL url = new URL(REQUEST_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            Map<String, String> parameters = makeParameterMap(code);

            connection.connect();

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getQueryStringFromMap(parameters));

            connection.disconnect();
            out.close();
            response = getJsonResponse(connection);

        } catch (IOException e) {
            System.out.println("error msg ::" + e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

    private Map getJsonResponse(HttpURLConnection connection) throws IOException {
        InputStream response = connection.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, Map.class);
    }

    private Map<String, String> makeParameterMap(String code) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "authorization_code");
        parameters.put("client_id", API_KEY);
        parameters.put("redirect_uri", REDIRECTED_URL);
        parameters.put("code", code);
        return parameters;
    }

    private User getUser(Map<String, String> token) {
        User user = null;
        try {
            URL url = new URL("https://kapi.kakao.com//v2/user/me");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            String accessToken = "Bearer " + token.get("access_token");
            connection.setRequestProperty("Authorization", accessToken);

            Map response = getJsonResponse(connection);
            String username = String.valueOf(response.get("id"));

            user = userDao.selectByUsername(username);

            if (user == null) {
                String nickname = (String) ((HashMap) response.get("properties")).get("nickname");
                user = new User(username, nickname, "user");
                this.register(user);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
