package net.htmlonline.domain.manytoone;

import java.util.List;

public class Userm {
    private int uid;
    private String name;
    private int age;

    private List<Orderm> list;

    public List<Orderm> getList() {
        return list;
    }

    public void setList(List<Orderm> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Userm{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
}
