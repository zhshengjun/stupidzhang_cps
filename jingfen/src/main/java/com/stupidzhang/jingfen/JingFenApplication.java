package com.stupidzhang.jingfen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.stupidzhang")
public class JingFenApplication {

    public static void main(String[] args) {
        SpringApplication.run(JingFenApplication.class, args);
    }

}
