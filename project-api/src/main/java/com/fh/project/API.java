package com.fh.project;

import com.fh.project.entity.People;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class API {


    public static void main(String[] args) {
        SpringApplication.run(API.class,args);
    }
}
