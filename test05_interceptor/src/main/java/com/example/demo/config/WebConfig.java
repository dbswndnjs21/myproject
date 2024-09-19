package com.example.demo.config;

import com.example.demo.interceptor.LogInterceptor;
import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 인터셉터를 만들어두면 addPath에 맞는 url이 mapping되면 실행된다
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**") // 하위 모든 경로 검사
                .excludePathPatterns("/css/**", "/*.ico"); // 해당 경로 제외

        registry.addInterceptor(new LoginInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/member/join", "/member/login", "/member/logout", "/css/**");
        
    }
}
