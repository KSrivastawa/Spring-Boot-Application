package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentException;
import com.example.demo.service.StudentServiceImpl;

@RestController
@RequestMapping("student/api")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;
    
    @GetMapping("/")
    public String Home() {
    	return "Welcome to Crud Operations";
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveStudentHandler(@RequestBody Student student) throws StudentException {

        String message = studentServiceImpl.saveStudent(student);
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    @PutMapping("/update/{student_id}")
    public ResponseEntity<String> updateStudentHandler(@PathVariable Integer student_id, @RequestBody Student student) throws StudentException {

        String message = studentServiceImpl.updateStudentById(student_id, student);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity<String> deleteStudentHandler(@PathVariable Integer student_id) throws StudentException {

        String message = studentServiceImpl.deleteStudentById(student_id);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @GetMapping("/get/{student_id}")
    public ResponseEntity<Student> getStudentHandler(@PathVariable Integer student_id) throws StudentException {

        Student student = studentServiceImpl.getStudentById(student_id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<Iterable<Student>> getAllStudentHandler() throws StudentException {

        Iterable<Student> students = studentServiceImpl.getAllStudent();
        return new ResponseEntity<Iterable<Student>>(students, HttpStatus.OK);
    }
}
