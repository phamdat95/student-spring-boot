package com.example.bootemo.service.imp;

import com.example.bootemo.model.Department;
import com.example.bootemo.repository.DepartmentRepository;
import com.example.bootemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }
}
