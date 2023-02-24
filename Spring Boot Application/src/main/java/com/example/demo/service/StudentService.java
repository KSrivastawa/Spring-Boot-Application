package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentException;

public interface StudentService {
	
	public String saveStudent(Student student) throws StudentException;
	public String updateStudentById(Integer student_id, Student student) throws StudentException;
    public String deleteStudentById(Integer student_id) throws StudentException;
    public Student getStudentById(Integer student_id) throws StudentException;
    public List<Student> getAllStudent() throws StudentException;

}
