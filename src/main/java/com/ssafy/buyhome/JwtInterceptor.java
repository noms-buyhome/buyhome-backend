package com.ssafy.buyhome;

import com.ssafy.buyhome.user.model.exception.UserUnauthorizedException;
import com.ssafy.buyhome.util.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final static String AUTH_HEADER = "Authorization";
    private final TokenProvider tokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(AUTH_HEADER);

        if (token != null && tokenProvider.validateAccessToken(token)) return true;

        throw new UserUnauthorizedException();
    }

}
