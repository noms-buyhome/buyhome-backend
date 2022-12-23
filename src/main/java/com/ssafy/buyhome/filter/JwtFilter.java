package com.ssafy.buyhome.filter;


import com.ssafy.buyhome.user.model.exception.UserUnauthorizedException;
import com.ssafy.buyhome.util.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Order(1)
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final static String AUTH_HEADER = "Authorization";
    private final TokenProvider tokenProvider;
    private static final String[] NO_NEED_AUTH_PREFIX = {"/api/auth", "/api/home"};

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader(AUTH_HEADER);
        if (token != null && tokenProvider.validateAccessToken(token)) {
            String username = tokenProvider.getUsernameFromToken(token);
            request.setAttribute("username", username); // token이 존재할 경우 request에 담아서 전송(controller에서 접근할 수 있게)
            chain.doFilter(request, response);
        } else {
            throw new UserUnauthorizedException();
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        if (method.equals("OPTIONS")) return true; //method가 options일 경우는 preflight이므로 헤더에 token이 포함되지 않음
        for (String url : NO_NEED_AUTH_PREFIX) {
            if (requestURI.startsWith(url)) return true;
        }
        return false;
    }
}
