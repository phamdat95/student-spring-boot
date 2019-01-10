package com.example.bootemo.service;

import com.example.bootemo.model.Department;

public interface DepartmentService {
    Department findById(Long id);

    Iterable<Department> findAll();
}
