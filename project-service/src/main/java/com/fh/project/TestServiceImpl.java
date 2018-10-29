package com.fh.project;

import com.fh.project.entity.People;
import org.springframework.stereotype.Service;

//@Service
public class TestServiceImpl implements TestService {

    @Override
    public String info() {
        return "service实现类。";
    }

    @Override
    public People getPeople() {
        return new People();
    }
}
