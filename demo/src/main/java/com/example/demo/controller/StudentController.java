package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController ("/student")
public class StudentController {
    @Autowired
    private IStudentRepository iStudentRepository;

    @GetMapping("/get")
    public List<Student> getAllStudents() {
        return iStudentRepository.findAll();
    }

    @PostMapping("/new")
    public Student addStudent(@RequestBody Student newStudent) {
        return iStudentRepository.save(newStudent);
    }

    @PatchMapping("/edit/{id}")
    public Student editStudent(@PathVariable Integer id, @RequestBody Student student) {
        Optional<Student> studentOptional = iStudentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student currentStudent = studentOptional.get();
            currentStudent.setNia(student.getNia());
            currentStudent.setName(student.getName());
            currentStudent.setSurname(student.getSurname());
            return iStudentRepository.save(currentStudent);
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id) {
        return iStudentRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        iStudentRepository.deleteById(id);
    }
}
