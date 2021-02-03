package com.example.demo1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data 注解在类上；提供getting、setting、equals、canEqual、hashCode、toString方法
@Data
//@NoArgsConstructor提供一个无参的构造方法
@NoArgsConstructor
//@AllArgsConstructor提供一个全参的构造方法
@AllArgsConstructor

public class Person {

    private String UserName;
    private int Age;
}
