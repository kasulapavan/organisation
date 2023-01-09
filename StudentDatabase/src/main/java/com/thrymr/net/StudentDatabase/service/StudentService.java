package com.thrymr.net.StudentDatabase.service;
import com.thrymr.net.StudentDatabase.dto.StudentDAO;
import com.thrymr.net.StudentDatabase.entity.Student;
import com.thrymr.net.StudentDatabase.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService implements StudentInterface {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    public ModelMapper modelMapper;
    public  List<StudentDAO> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        List<StudentDAO> studentDAOList = new ArrayList<>();
        for (Student student :studentList){
            studentDAOList.add(modelMapper.map(student,StudentDAO.class));
        }
         return studentDAOList;
    }
    public StudentDAO saveStudent(StudentDAO studentDAO){
Student student = modelMapper.map(studentDAO,Student.class);
        studentRepository.save(student);
        return modelMapper.map(student,StudentDAO.class);
    }
    public StudentDAO updateStudent(Integer id, StudentDAO studentDAO){
        Student student1 = modelMapper.map(studentDAO,Student.class);
         if(student1.getId().equals(id)){
             studentRepository.save(student1);
             studentDAO = modelMapper.map(student1,StudentDAO.class);
         }
     return studentDAO;
    }
    public String deleteStudent(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
            return "Student record is delete successfully";
        }
        else return "student details is not found";
    }
    public Optional<StudentDAO> getById(Integer id){
      return getAllStudent().stream().filter(studentDAO -> studentDAO.getId().equals(id)).findFirst();
    }

public List<StudentDAO> findByOrder(OrderBy order){
List<Student> studentList = new ArrayList<Student>();
if(order.equals(OrderBy.ASC)){
    studentList =  studentRepository.findAllByOrderByNameAsc();
}
else if(order.equals(OrderBy.DESC)){
    studentList = studentRepository.findAllByOrderByNameDesc();
}
    return studentList.stream().map(student -> modelMapper.map(student, StudentDAO.class)).toList();
    }

    public List<StudentDAO> findGreaterThanAge(Integer age){
        List<Student> studentList = studentRepository.findTop2AllByAgeGreaterThan(age);
        return studentList.stream().map(student -> modelMapper.map(student,StudentDAO.class)).toList();

    }

    public List<StudentDAO> findStudentNameStartsAndLessThanAge(Character name, Integer age){

        List<Student> studentList = studentRepository.findAllByNameStartingWithAndAgeLessThan(name, age);
        return studentList.stream().map(student -> modelMapper.map(student,StudentDAO.class)).toList();

    }


}