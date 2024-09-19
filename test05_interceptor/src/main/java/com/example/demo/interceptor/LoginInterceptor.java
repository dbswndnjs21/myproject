package com.example.demo.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

// 로그인했는지 검사하는 로직
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        if (session == null || id == null) {
            response.sendRedirect("/member/login");
            return false;
        }
        return true;
    }
}
