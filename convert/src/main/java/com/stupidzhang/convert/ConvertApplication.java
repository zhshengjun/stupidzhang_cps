package com.stupidzhang.convert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.stupidzhang")
public class ConvertApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConvertApplication.class, args);
    }

}
