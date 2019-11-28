package com.liuyang.lambda;

import lombok.Data;

/**
 * describe:
 *
 * @author: liuyang181
 * @date: 2019/11/24 下午10:04
 */
@Data
public class Student {

    String name;

    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
