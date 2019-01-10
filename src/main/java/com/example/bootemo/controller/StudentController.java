package com.example.bootemo.controller;

import com.example.bootemo.model.Department;
import com.example.bootemo.model.Student;
import com.example.bootemo.service.DepartmentService;
import com.example.bootemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("department")
    public Iterable<Department> departments(){
        return departmentService.findAll();
    }

    @GetMapping("list")
    public ModelAndView showList(@PageableDefault(size = 5)Pageable pageable){
        Page<Student> students = studentService.findAll(pageable);
        return new ModelAndView("list","student",students);
    }
    @GetMapping("create")
    public ModelAndView showCreate(){
        return new ModelAndView("create","student", new Student());
    }
    @PostMapping("create")
    public ModelAndView createStudent(@Validated @ModelAttribute("student") Student student, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("create");
        if (result.hasFieldErrors()){
            modelAndView.addAllObjects(result.getModel());
            return modelAndView;
        } else {
        studentService.save(student);
        modelAndView.addObject("message","success");
        return modelAndView;
        }
    }
    @GetMapping("edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        Student student = studentService.findById(id);
        return new ModelAndView("edit","student",student);
    }
    @PostMapping("edit")
    public ModelAndView editStudent(@Validated @ModelAttribute("student") Student student,BindingResult result){
        ModelAndView modelAndView = new ModelAndView("edit");
        if (result.hasFieldErrors()){
            modelAndView.addAllObjects(result.getModel());
            return modelAndView;
        } else {
            studentService.save(student);
            modelAndView.addObject("message","successful");
            return modelAndView;
        }

    }
    @GetMapping("delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id){
        Student student = studentService.findById(id);
        return new ModelAndView("delete","student",student);
    }
    @PostMapping("delete")
    public ModelAndView deleteStudent(@ModelAttribute("student") Student student){
        studentService.remove(student.getId());
        return new ModelAndView("redirect:list");
    }
    @GetMapping("list-search")
    public ModelAndView showListSearch(@RequestParam("s") String s,@PageableDefault(size = 5) Pageable pageable){
        Page<Student> students = studentService.findByCode(s,pageable);
        ModelAndView modelAndView = new ModelAndView("list-search");
        modelAndView.addObject("student",students);
        modelAndView.addObject("s",s);
        return modelAndView;
    }
}
