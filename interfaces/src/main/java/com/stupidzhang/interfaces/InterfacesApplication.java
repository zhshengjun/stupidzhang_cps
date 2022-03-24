package com.stupidzhang.interfaces;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Configurable
@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = "com.stupidzhang")
public class InterfacesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterfacesApplication.class, args);
    }

}
