package com.fh.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${baseDir}")
    private String baseDir;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return baseDir;
    }

}
