package com.example.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {
    String[] whiteList ={"/", "/member/login", "/member/join", "/member/logout", "/css"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURI(); // 요청 url 얻어오기
        HttpSession session = req.getSession();
        if (isLoginCheck(url)) {
            if (session == null || session.getAttribute("id") == null) {
                res.sendRedirect("/member/login");
                return;
            }
        }
        // 꼭 해야함
        chain.doFilter(request, response);
    }

    private boolean isLoginCheck(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whiteList, requestURI);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
