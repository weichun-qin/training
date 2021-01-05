package com.ives.training.entity;

/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/9/21 14:23
 */
public class User {
    String name;
    Integer age;
    String attributes;

    public User(){}

    public User(String name, Integer age, String attributes) {
        this.name = name;
        this.age = age;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", attributes='" + attributes + '\'' +
                '}';
    }
}
