package by.clevertec.starter.monitor.performance.aspect;

import by.clevertec.starter.monitor.performance.config.PerformanceMonitorProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
@RequiredArgsConstructor
public class PerformanceMonitorAspect {

    private final PerformanceMonitorProperties properties;

    @Pointcut("@annotation(by.clevertec.starter.monitor.performance.annotation.MonitorPerformance)")
    public void isCallMonitorPerformanceAnnotation() {}


    @Around("isCallMonitorPerformanceAnnotation()")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) {
        long startMethod = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            long result;
            if((result = System.currentTimeMillis() - startMethod) < properties.getMinValueForLogging()) {
                log.info("Method {} execute in {} ms", joinPoint.getSignature().getName(), result);
            }
        }
    }

}
