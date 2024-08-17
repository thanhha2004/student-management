package com.example.demo.service;

import com.example.demo.entity.ClassEntity;
import com.example.demo.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public ClassEntity createClass(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

    public ClassEntity updateClass(Long id, ClassEntity classDetails) {
        ClassEntity classEntity = classRepository.findById(id).orElse(null);
        if (classEntity != null) {
            classEntity.setName(classDetails.getName());
            return classRepository.save(classEntity);
        }
        return null;
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    public ClassEntity getClassDetails(Long id) {
        return classRepository.findById(id).orElse(null);
    }
}
