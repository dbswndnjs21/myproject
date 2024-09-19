package com.example.demo.config;

import com.example.demo.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 인터셉터를 만들어두면 addPath에 맞는 url이 mapping되면 실행된다
        registry.addInterceptor(new AdminInterceptor())
                .order(1)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/css/**", "/*.ico"); // 해당 경로 제외


    }
}
