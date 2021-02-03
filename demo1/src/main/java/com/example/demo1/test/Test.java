package com.example.demo1.test;

import com.example.demo1.bean.Person;

public class Test {

    public static void main(String[] args) {
        Person person = new Person("name", 20);
        System.out.println(person.toString());
    }
}
