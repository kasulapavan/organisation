package com.thrymr.net.StudentDatabase.dto;
import com.thrymr.net.StudentDatabase.entity.Gender;
import lombok.*;

import java.io.File;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDAO {

    private   Integer id;
    private     Integer age;
    private String name;
    private Float salary;
   private Gender gender;
    private String address;
    private Date joiningDate;
    private File file;




}