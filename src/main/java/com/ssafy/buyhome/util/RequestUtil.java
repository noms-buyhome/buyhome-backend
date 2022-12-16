package com.ssafy.buyhome.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public static String getUsernameFromRequest(HttpServletRequest request) {
        return (String) request.getAttribute("username");
    }
}
