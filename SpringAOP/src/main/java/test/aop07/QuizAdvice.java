package test.aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class QuizAdvice {

    @Pointcut("execution(public * test.aop03..*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
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
