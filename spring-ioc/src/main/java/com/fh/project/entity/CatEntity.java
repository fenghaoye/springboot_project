package com.fh.project.entity;

import com.fh.project.annotation.TableName;

@TableName("cat")
public class CatEntity {

    private int id;

    private String catAge;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatAge() {
        return catAge;
    }

    public void setCatAge(String catAge) {
        this.catAge = catAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
