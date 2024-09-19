package test.aop06;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExecuteTimeAdvice1 {
    // 포인트 컷 메소드 - 리턴형이 void이여야 하며 어노테이션으로 포인트컷을 설정한다
    @Pointcut("execution(public * test.aop03..*(..))")
    public void timeTarget() {


    }
    @Around("timeTarget()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        double time = (endTime - startTime) / 1000.0;
        System.out.println("[" + methodName + "] " + time + " ms");
        return result;
    }
}
