package com.stupidzhang.domain.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@RefreshScope
@Configuration
public class PlatformConfig {

    public static String platformType;

    @Value("${cps.platform.type:}")
    public void setPlatform(String type) {
        platformType = type;
    }
}
