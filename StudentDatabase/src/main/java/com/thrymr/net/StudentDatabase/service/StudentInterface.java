package com.thrymr.net.StudentDatabase.service;

import com.thrymr.net.StudentDatabase.dto.StudentDAO;
import java.util.List;
import java.util.Optional;

public interface StudentInterface {

    public List<StudentDAO> getAllStudent();

    public StudentDAO saveStudent(StudentDAO student);

    public StudentDAO updateStudent(Integer id,StudentDAO studentDAO);

    public String deleteStudent(Integer id);
    public Optional<StudentDAO> getById(Integer id);
    public List<StudentDAO> findByOrder(OrderBy order);

    public List<StudentDAO> findGreaterThanAge(Integer age);

    public List<StudentDAO> findStudentNameStartsAndLessThanAge(Character name, Integer age);

}
