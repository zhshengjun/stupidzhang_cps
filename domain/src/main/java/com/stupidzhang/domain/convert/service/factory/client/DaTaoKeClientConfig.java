package com.stupidzhang.domain.convert.service.factory.client;

import com.dtk.api.client.DtkApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaTaoKeClientConfig {


    @Value("${convert.platform.dataoke.appKey:}")
    private String appKey;

    @Value("${convert.platform.dataoke.appSecret:}")
    private String appSecret;


    @Bean
    public DtkApiClient dtkApiClient(){
        return DtkApiClient.getInstance(appKey,appSecret);
    }
}
