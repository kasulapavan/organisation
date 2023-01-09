package com.thrymr.net.StudentDatabase.repository;

import com.thrymr.net.StudentDatabase.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByOrderByNameAsc();
    List<Student> findAllByOrderByNameDesc();
    List<Student> findTop2AllByAgeGreaterThan(Integer age);
    List<Student> findAllByNameStartingWithAndAgeLessThan(Character name, Integer age);



}
