package com.fh.project.controller;

import com.fh.project.service.PowerServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private static final String URL="http://SERVER-POWER";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    PowerServiceClient powerServiceClient;


    @RequestMapping("/power.do")
    public Object power(){
        return  restTemplate.getForObject(URL+"/power.do",Object.class);
    }


    @RequestMapping("/feignPower.do")
    public Object feignPower(){
        return  powerServiceClient.power();
    }


}
