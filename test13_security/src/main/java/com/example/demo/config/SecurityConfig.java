package com.example.demo.config;

import com.example.demo.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrfConfigurer-> csrfConfigurer.disable()) //csrf 토근 사용하지 않기
                .authorizeRequests(authz -> authz
                        .requestMatchers("/member/**").authenticated()// 인증된 사용자만 접근 허용
//                        .requestMatchers("/admin/**").authenticated()
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")// ADMIN이라는 권한이 있는지 검사
                        .anyRequest().permitAll()) // 나머지 요청은 인증 없이 모두 접근가능
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // login페이지
                        .loginProcessingUrl("/loginOk") // login 페이지의 action 속성 / 이 설정안주면 login이 url이래
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout((logoutConfig) -> logoutConfig.logoutSuccessUrl("/") // 따로 설정하지 않으면 logout으로 기본으로설정됨
                )
                    .userDetailsService(customUserDetailsService);
        return http.build();
    }
}
