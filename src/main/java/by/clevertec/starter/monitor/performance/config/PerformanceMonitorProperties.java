package by.clevertec.starter.monitor.performance.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "monitor.performance")
public class PerformanceMonitorProperties {

    private boolean enable;
    private long minValueForLogging;

}
