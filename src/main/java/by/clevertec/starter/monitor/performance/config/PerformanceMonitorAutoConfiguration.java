package by.clevertec.starter.monitor.performance.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
public class PerformanceMonitorAutoConfiguration {

}
