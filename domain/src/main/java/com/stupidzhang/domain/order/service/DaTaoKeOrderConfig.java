package com.stupidzhang.domain.order.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@RefreshScope
@Configuration
public class DaTaoKeOrderConfig {

    @Value("${cps.platform.dataoke.appKey:}")
    private String appKey;

    @Value("${cps.platform.dataoke.appSecret:}")
    private String appSecret;
}
