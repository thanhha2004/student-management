package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setFullName(studentDetails.getFullName());
            student.setPhone(studentDetails.getPhone());
            student.setBirth(studentDetails.getBirth());
            student.setMath(studentDetails.getMath());
            student.setEnglish(studentDetails.getEnglish());
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudentDetails(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudentsByClassId(Long classId) {
        return studentRepository.findByClassEntityId(classId);
    }

    public List<Student> getStudentsInLargestClass() {
        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream()
                .filter(student -> student.getClassEntity().getStudents().size() == allStudents.stream()
                        .mapToInt(s -> s.getClassEntity().getStudents().size()).max().orElse(0))
                .toList();
    }
}
