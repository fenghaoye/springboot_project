package com.fh.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping("/getUser")
    public Map<String,Object> getUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("username","fh");
        return map;
    }
}
