package com.fh.project.Test;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/10/19 8:43 上午
 */
public class Son extends Father {

    @Override
    public String test() {
        return "";
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.setId("1");
    }
}
