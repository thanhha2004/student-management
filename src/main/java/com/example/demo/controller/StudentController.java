package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/{id}")
    public Student getStudentDetails(@PathVariable Long id) {
        return studentService.getStudentDetails(id);
    }

    @GetMapping("/class/{classId}")
    public List<Student> getStudentsByClassId(@PathVariable Long classId) {
        return studentService.getStudentsByClassId(classId);
    }

    @GetMapping("/largest-class")
    public List<Student> getStudentsInLargestClass() {
        return studentService.getStudentsInLargestClass();
    }
}
