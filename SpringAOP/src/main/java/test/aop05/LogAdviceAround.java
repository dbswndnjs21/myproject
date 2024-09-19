package test.aop05;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
* 로그 레벨 
* TRACE DEBUG 보다 더 세부적인 정보 이벤트를 지정
* DEBUG 어플리케이션을 디버깅하는ㄷ 데 가장 유용한 세부적인 정보 이벤트를 지정
* INFO 응용 프로그램의 진행 상황을 대략적으로 강조하는 정보 메세지를 지정
* WARN 잠재적으로 유해한 상황을 나타냄
* ERROR 애플리케이션이 계속 실행될 수 있도록 하는 오류 이벤트를 지정
* FATAL 응용 프로그램을 중단시킬 수 있는 매우 심각한오류 이벤트를 지정
* OFF 로깅해제
*
* TRACE < DEBUG < INFO <WARN <ERROR < FATAL
* 
* WARN을 로그 레벨로 지정을 하게 되면 그 아래 WARN, ERROR, FATAL 까지 로그가 찍히게 됨
* 
* 
*/

// 메소스 실행 전후를 동작하는 어드비져 만들긴
public class LogAdviceAround implements MethodInterceptor {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 메소스 실행 전 작업
        Object[] args = invocation.getArguments();
        String methodName = invocation.getMethod().getName();
        if (logger.isDebugEnabled()) {
            logger.debug(methodName + " 메소드 호출!");
            logger.debug("<< 전달된 파라미터 >>");
            for (Object a : args) {
                logger.debug(a + " ");
            }
            logger.debug("...................");
        }

        Object returnValue = invocation.proceed(); // 이걸 기점으로 전 후
        System.out.println("실행 후");
        
        // 메소드 실행 후 작업
        return null;
    }
}
