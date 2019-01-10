package com.example.bootemo;

import com.example.bootemo.service.DepartmentService;
import com.example.bootemo.service.StudentService;
import com.example.bootemo.service.imp.DepartmentServiceImp;
import com.example.bootemo.service.imp.StudentServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootemoApplication.class, args);
	}
@Bean
	public StudentService studentService(){return new StudentServiceImp();
}
@Bean
	public DepartmentService departmentService(){return new DepartmentServiceImp();
}
}

