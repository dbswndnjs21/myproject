package com.example.demo.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        System.out.println(role);
        if (!role.equals("ADMIN")) {
          session.setAttribute("msg", "관리자 페이지의 권한이 없습니다");
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
