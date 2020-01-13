package com.fh.project.basic.equal;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        // 判断引用是否相等
        if (this == object) return true;
        // 判断类型是否相等
        if (object == null || getClass() != object.getClass()) return false;
        // 判断name属性是否相等
        Student student = (Student) object;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {

        Student student1 = new Student(18, "张三");
        Student student2 = new Student(19, "张三");
        System.out.println(student1.equals(student2));

        Set set = new HashSet();
        set.add(student1);
        set.add(student2);
        System.out.println(set.size());

    }
}
