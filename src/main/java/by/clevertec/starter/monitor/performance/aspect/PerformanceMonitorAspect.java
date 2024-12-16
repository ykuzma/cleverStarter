package by.clevertec.starter.monitor.performance.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
@Slf4j
@RequiredArgsConstructor
public class PerformanceMonitorAspect {

    private final long minValueForLogging;

    @Pointcut("@annotation(by.clevertec.starter.monitor.performance.annotation.MonitorPerformance)")
    public void isCallMonitorPerformanceAnnotation() {
    }


    @Around("isCallMonitorPerformanceAnnotation()")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long result;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return joinPoint.proceed();
        } finally {
            stopWatch.stop();
            if ((result = stopWatch.getTotalTimeMillis()) >= minValueForLogging) {
                log.info("Method {} execute in {} ms", joinPoint.getSignature().getName(), result);
            }
        }
    }

}
