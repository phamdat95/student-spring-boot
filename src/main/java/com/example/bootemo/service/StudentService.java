package com.example.bootemo.service;

import com.example.bootemo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> findAll(Pageable pageable);

    Student findById(Long id);

    void save(Student student);

    void remove(Long id);

    Page<Student> findByCode(String code, Pageable pageable);
}
