package com.jdbctemplate.pojo;

public class User {

    private int id;
    private int create_at;
    private int update_at;
    private String name;
    private int age;
    private int sex;
    private String pro;
    private String brother;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreate_at() {
        return create_at;
    }

    public void setCreate_at(int create_at) {
        this.create_at = create_at;
    }

    public int getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(int update_at) {
        this.update_at = update_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", pro='" + pro + '\'' +
                ", brother='" + brother + '\'' +
                '}';
    }


}
