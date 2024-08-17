package com.example.demo.controller;

import com.example.demo.entity.ClassEntity;
import com.example.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    public ClassEntity createClass(@RequestBody ClassEntity classEntity) {
        return classService.createClass(classEntity);
    }

    @PutMapping("/update/{id}")
    public ClassEntity updateClass(@PathVariable Long id, @RequestBody ClassEntity classDetails) {
        return classService.updateClass(id, classDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.ok("Class deleted successfully");
    }

    @GetMapping("/get/{id}")
    public ClassEntity getClassDetails(@PathVariable Long id) {
        return classService.getClassDetails(id);
    }
}
