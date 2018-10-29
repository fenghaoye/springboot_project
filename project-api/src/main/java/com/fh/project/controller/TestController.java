package com.fh.project.controller;

import com.fh.project.TestService;
import com.fh.project.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${baseDir}")
    private String baseDir;

    @Autowired
    private TestService testService;
    @Autowired
    private People people;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return testService.info();
    }

    @RequestMapping("/getPeople")
    @ResponseBody
    public People getPeople(){
        return people;
    }

}
