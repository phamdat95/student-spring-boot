package com.example.bootemo.service.imp;

import com.example.bootemo.model.Student;
import com.example.bootemo.repository.StudentRepository;
import com.example.bootemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(findById(id));
    }

    @Override
    public Page<Student> findByCode(String code, Pageable pageable) {
        return studentRepository.findAllByCodeContaining(code,pageable);
    }
}
