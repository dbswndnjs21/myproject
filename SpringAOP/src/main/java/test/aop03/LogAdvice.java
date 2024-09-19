package test.aop03;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAdvice {
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        
        // 메소드 실행전에 수행될 기능
        Object[] args = joinPoint.getArgs(); // 메소드에 전달된 파라미터 값 얻어오기 -> Object[]로 return 해줌
        long bt = System.currentTimeMillis();
        
        Object returnValue = joinPoint.proceed(); // 메소드(핵심로직)가 호출되어 수행됨

        // 메소드 실행후에 수행될 기능
        long at = System.currentTimeMillis();
        System.out.println("동작 시간 : " + (at- bt)/1000.0  + " 초");

        return returnValue;
        
    }
}
