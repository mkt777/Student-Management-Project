package com.genie.JPADemo.service;

import com.genie.JPADemo.dao.StudentRequest;
import com.genie.JPADemo.entity.Student;
import com.genie.JPADemo.repo.StudentRepo;
import com.genie.JPADemo.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StdServiceImpl implements StdService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudentByCourse(String courseName) {
        return studentRepo.findByCourse(courseName);
    }

    @Override
    public Student saveStdData(StudentRequest studentRequest) {
        return studentRepo.save(Utility.Mapper(studentRequest));
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.getAllStudentData();
    }


    @Override
    public Student updateStudent(int id, StudentRequest studentRequest) {
        Optional<Student> existingStudentOpt = studentRepo.findById(id);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            // Update the student fields
            existingStudent.setName(studentRequest.getName());
            existingStudent.setCourse(studentRequest.getCourse());
            existingStudent.setAddress(studentRequest.getAddress());
            existingStudent.setDOB(studentRequest.getDOB());
            existingStudent.setEnrolmentNum(studentRequest.getEnrolmentNum());

            // Save the updated student back to the database
            return studentRepo.save(existingStudent);
        } else {
            // Handle case when the student with the given ID doesn't exist
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

}
