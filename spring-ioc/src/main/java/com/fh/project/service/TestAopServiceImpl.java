package com.fh.project.service;

import org.springframework.stereotype.Service;

@Service
public class TestAopServiceImpl implements TestAopService{

    @Override
    public void hello() {
        System.out.println("service method....");
    }
}
