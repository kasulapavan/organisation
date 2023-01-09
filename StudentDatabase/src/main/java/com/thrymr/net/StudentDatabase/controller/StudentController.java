package com.thrymr.net.StudentDatabase.controller;

import com.thrymr.net.StudentDatabase.dto.StudentDAO;
import com.thrymr.net.StudentDatabase.service.OrderBy;
import com.thrymr.net.StudentDatabase.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/save")
    public StudentDAO save(@RequestBody StudentDAO studentDAO){
    return studentService.saveStudent(studentDAO);
    }
    @GetMapping("/get")
    public List<StudentDAO> getAllStudent(){
        return studentService.getAllStudent();
    }
    @PutMapping("/update/{id}")
    public StudentDAO update(@PathVariable("id") Integer id ,@RequestBody StudentDAO studentDAO){
    return studentService.updateStudent(id, studentDAO);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
      return studentService.deleteStudent(id);
    }
    @GetMapping("get-by-id/{id}")
    public Optional<StudentDAO>getById(@PathVariable Integer id){
        return studentService.getById(id);
    }



    @GetMapping("find-by-order/{order}")
    public List<StudentDAO> findByOrder(@PathVariable OrderBy order){
        return studentService.findByOrder(order);
    }

    @GetMapping("greater-then-age/{age}")
    public List<StudentDAO> findGreaterThanAge(@PathVariable Integer age){
        return studentService.findGreaterThanAge(age);
    }

    @GetMapping("name-starts/{name}/{age}")
    public List<StudentDAO> findStudentNameStartsAndLessThanAge(@PathVariable("name") Character name, @PathVariable("age") Integer age){
        return studentService.findStudentNameStartsAndLessThanAge(name, age);
    }
}