package by.clevertec.starter.monitor.performance.config;

import by.clevertec.starter.monitor.performance.aspect.PerformanceMonitorAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
public class PerformanceMonitorAutoConfiguration {

    @Bean
    @ConditionalOnProperty("monitor.performance.enable")
    public PerformanceMonitorAspect aspect(PerformanceMonitorProperties properties) {
        return new PerformanceMonitorAspect(properties.getMinValueForLogging());
    }
}
