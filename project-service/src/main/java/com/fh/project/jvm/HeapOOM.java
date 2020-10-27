package com.fh.project.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/4/12 12:21 上午
 */
public class HeapOOM {

    public static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
