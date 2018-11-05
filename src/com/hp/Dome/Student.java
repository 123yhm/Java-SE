package com.hp.Dome;

import javax.swing.*;

/**
 * --@Name:浩明
 * 学生类---学号 姓名 年龄
 */
public class Student {
    private Integer stuId;
    private String stuName;
    private Integer stuAge;

    public Student() {
        super();
    }
    public Student(Integer stuId,String stuName,Integer stuAge) {
        super();
        this.stuId=stuId;
        this.stuName=stuName;
        this.stuAge=stuAge;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }


}
