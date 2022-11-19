package com.ssafy.buyhome.user.model.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.buyhome.user.model.dto.Token;
import com.ssafy.buyhome.util.ParameterStringBuilder;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private static final String REQUEST_URL = "https://kauth.kakao.com/oauth/token";
    private static final String API_KEY = "f427e8067a6aef6575b4e51dd60be434";
    private static final String REDIRECTED_URL = "http://localhost:8080/api/auth/login";
    private static final String CLIENT_SECRET = "4evW0M6AzlFNG3ZzqfZourQYivYTCntS";

    public Token getKakaoToken(String code) {
        Token token = new Token();
        try {
            URL url = new URL(REQUEST_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            Map<String, String> parameters = getParameters(code);

            connection.connect();

            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getQueryStringFromMap(parameters));

            Map<String, String> response = getJsonResponse(connection);

            token.setAccess(response.get("access_token"));
            token.setRefresh(response.get("refresh_token"));

            connection.disconnect();
            out.close();
        } catch (IOException e) {
            System.out.println("error msg ::" + e.getMessage());
            e.printStackTrace();
        }

        return token;
    }

    private Map<String, String> getJsonResponse(HttpURLConnection connection) throws IOException {
        InputStream response = connection.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, Map.class);
    }

    private Map<String, String> getParameters(String code) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "authorization_code");
        parameters.put("client_id", API_KEY);
        parameters.put("redirect_uri", REDIRECTED_URL);
        parameters.put("code", code);
        return parameters;
    }
}
