package com.ssafy.buyhome.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse filteredResponse = (HttpServletResponse) response;
        filteredResponse.setHeader("Access-Control-Allow-Origin", "*");
        filteredResponse.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE, PUT");
        filteredResponse.setHeader("Access-Control-Max-Age", "3600");
        filteredResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,x-requested-with,Authorization,Access-Control-Allow-Origin");

        chain.doFilter(request, filteredResponse);
    }
}
