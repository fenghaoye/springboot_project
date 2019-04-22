package com.fh.project;

import com.fh.project.entity.People;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("test2ServiceImpl")
public class Test2ServiceImpl implements TestService {

    @Override
    public String info() {
        return "service实现类2。";
    }

    @Override
    public People getPeople() {
        return new People();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list = tran(list);
        System.out.println("");


    }

    private static List<String> tran(List<String> list){
        for(String s : list){
            s = "1";
        }
        return list;
    }
}
