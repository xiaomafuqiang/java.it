package main.data;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentList implements Serializable {
    public static final long serialVersionUID = 1L;
    private ArrayList<Student> arrayList;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentList(ArrayList<Student> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<Student> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Student> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "arrayList=" + arrayList +
                '}';
    }
}
