package com.fh.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PowerController {

    @RequestMapping("/power.do")
    public Map<String,Object> power(){
        Map<String,Object> rMap = new HashMap<>();
        rMap.put("name","power6002");
        return  rMap;
    }

}
