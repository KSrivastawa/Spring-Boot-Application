package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentException;
import com.example.demo.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student) throws StudentException {
    	Student studentByRoll = studentRepository.findByStudentRoll(student.getStudentRoll());
        Student studentByImageUrl = studentRepository.findByImageUrl(student.getImageUrl());

           if (studentByRoll != null) {
             throw new StudentException("Student already exist with roll: " + student.getStudentRoll());
           }
           else if (studentByImageUrl != null) {
                 throw new StudentException("Student already exist with image url: " + student.getImageUrl());
           }
           else {
               studentRepository.save(student);
               return "Student saved successfully";
           }
    }

    @Override
    public String updateStudentById(Integer student_id, Student student) throws StudentException {

        Student studentByRoll = studentRepository.findByStudentRoll(student.getStudentRoll());
        Student studentByImageUrl = studentRepository.findByImageUrl(student.getImageUrl());

        if (studentByRoll != null) {
            throw new StudentException("Student already exist with roll: " + student.getStudentRoll());
        }
        else if (studentByImageUrl != null) {
            throw new StudentException("Student already exist with image url: " + student.getImageUrl());
        }
        else {
            studentRepository.save(student);
            return "Student updated successfully";
        }

    }

    @Override
    public String deleteStudentById(Integer student_id) throws StudentException {
        try {
            studentRepository.deleteById(student_id);
            return "Student deleted successfully";
        } catch (Exception e) {
            throw new StudentException("Student Id is not found!");
        }
    }

    @Override
    public Student getStudentById(Integer student_id) throws StudentException {
        try {
            return studentRepository.findById(student_id).get();
        } catch (Exception e) {
            throw new StudentException("Student Id is not found!");
        }
    }

    @Override
    public List<Student> getAllStudent() throws StudentException {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new StudentException("Student List is Empty");
        }
    }


}
