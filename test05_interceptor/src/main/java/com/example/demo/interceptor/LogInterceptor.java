package com.example.demo.interceptor;

/*
1) 스프링 인터셉터 흐름
HTTP 요청 -> WAS -> 필터 -> 서블릿 -> 스프링 인터셉터 -> 컨트롤러
서블릿 필터는 섭르릿이 호출되기 이전에 호출된다
스프링 인터셉터는 컨트롤러 호출 직전에 호춛된다
URL 패턴을 섭르릿 필터에 비해 정밀하게 설정할 수 있다.

2) interface HandlerInterceptor
<preHandle>
컨트롤러 호출 전 
return true : 다음 인터셉터 또는 컨트롤러가 호출된다
return false : 다음이 호출되지 않고 종료된다.

<postHandle > 
컨트롤러에서 예외가 발생하면 호출되지 않는다.

<afterCompletion > 
요청 완료 이후 항상 호출된다
 */

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            log.info("preHandle HandlerMethod: [{}][{}]", requestURI, handler);
            MethodParameter[] parameters = method.getMethodParameters();
            for (MethodParameter parameter : parameters) {
                log.info("parameter: [{}]", parameter);
            }
            log.info("preHandle end");
        }
        return true; // 다음인터셉터 또는 컨트롤러를 호출
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle..[{}],[{}]", handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion .[{}]", handler);
        if (ex != null) {
            log.info("afterCompletion exception", ex);
        }
    }
}

