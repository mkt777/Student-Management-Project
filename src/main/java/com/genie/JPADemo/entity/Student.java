package com.genie.JPADemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id ;

    @Column(name="name")
    String name ;

    @Column(name="course")
    String course;

    @Column(name="address")
    String address;

    @Column(name="DOB")
    String DOB ;

    @Column(name ="enrolmentNum")
    String enrolmentNum ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEnrolmentNum() {
        return enrolmentNum;
    }

    public void setEnrolmentNum(String enrolmentNum) {
        this.enrolmentNum = enrolmentNum;
    }
}
