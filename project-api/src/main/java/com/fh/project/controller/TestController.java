package com.fh.project.controller;

import com.fh.project.entity.People;
import com.fh.project.thread.threadpool.ThreadPoolDemo;
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
    private People people;
    @Autowired
    private ThreadPoolDemo threadPoolDemo;


    @RequestMapping("/threadPool")
    @ResponseBody
    public String threadPool(){
        threadPoolDemo.test();
        System.out.println("controller.........");
        return "执行完成";
    }



    @RequestMapping("/getPeople")
    @ResponseBody
    public People getPeople(){
        return people;
    }

}
