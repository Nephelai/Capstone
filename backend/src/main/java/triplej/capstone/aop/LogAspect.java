package triplej.capstone.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);


    // Entities 안에 Class 안에 Function 까지.
    // AOP 동작하는 부분 PointCut 설정
    @Pointcut("execution(* triplej.capstone.entities.*.*(..))")
    public void AllEntityPointCut() {
    }

    @Around("AllEntityPointCut()")
    public Object performanceLog(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable {
        Object result = null;
        long start = System.currentTimeMillis();
        result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        // Log 작업필요
        log.info("Code Info : " + proceedingJoinPoint.getSignature());
        log.info("Method : " + proceedingJoinPoint.getSignature().getName());
        log.info("Args : " + Arrays.toString(proceedingJoinPoint.getArgs()));
        log.info("Processing Time : " + (end - start));
        log.info("------------------------------------");

        return result;
    }
}
