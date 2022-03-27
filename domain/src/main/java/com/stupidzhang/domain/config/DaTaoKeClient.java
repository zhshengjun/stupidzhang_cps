package com.stupidzhang.domain.config;

import com.dtk.api.client.DtkApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
public class DaTaoKeClient {


    @Value("${cps.platform.dataoke.appKey:}")
    private String appKey;

    @Value("${cps.platform.dataoke.appSecret:}")
    private String appSecret;


    @Bean
    public DtkApiClient dtkApiClient(){
        return DtkApiClient.getInstance(appKey,appSecret);
    }
}
