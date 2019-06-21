package com.fh.project;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Server3000 {

    public static void main(String[] args) {
        SpringApplication.run(Server3000.class);
    }
}
