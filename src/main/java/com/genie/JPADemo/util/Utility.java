package com.genie.JPADemo.util;

import com.genie.JPADemo.dao.StudentRequest;
import com.genie.JPADemo.entity.Student;

public class Utility {
  // yeah student reuqest ka object lega aur usko convert kar dega
    public static Student Mapper(StudentRequest studentRequest){
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAddress(studentRequest.getAddress());
        student.setCourse(studentRequest.getCourse());
        return student ;
    }
}
