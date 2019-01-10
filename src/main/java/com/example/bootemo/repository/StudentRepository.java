package com.example.bootemo.repository;

import com.example.bootemo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Page<Student> findAllByCodeContaining(String code, Pageable pageable);
}
