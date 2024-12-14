package by.clevertec.starter.monitor.performance.config;

import by.clevertec.starter.monitor.performance.TestService;
import by.clevertec.starter.monitor.performance.aspect.PerformanceMonitorAspect;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
public class PerformanceMonitorAutoConfiguration {

    @Bean
    public TestService testService(PerformanceMonitorProperties properties) {
        return new TestService(properties.isEnable(), properties.getMinValueForLogging());
    }

    @Bean
    public PerformanceMonitorAspect aspect(PerformanceMonitorProperties properties) {
        return new PerformanceMonitorAspect(properties);
    }
}
