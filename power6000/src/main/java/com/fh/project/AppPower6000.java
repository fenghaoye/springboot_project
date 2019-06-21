package com.fh.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AppPower6000 {

    public static void main(String[] args) {
        SpringApplication.run(AppPower6000.class);
    }
}
