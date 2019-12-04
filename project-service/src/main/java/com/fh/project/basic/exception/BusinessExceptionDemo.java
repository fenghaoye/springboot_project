package com.fh.project.basic.exception;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BusinessExceptionDemo  {

    public void test(){
            System.out.println("");
            throw new BusinessException("xxxx");
    }
}
