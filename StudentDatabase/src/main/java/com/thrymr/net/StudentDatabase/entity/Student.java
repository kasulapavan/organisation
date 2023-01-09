package com.thrymr.net.StudentDatabase.entity;
import jakarta.persistence.*;
import lombok.*;
import java.io.File;
import java.util.Date;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Integer id;
    private     Integer age;
    private   String name;
    @Enumerated(EnumType.STRING)
 private   Gender gender;
    @Column(columnDefinition = "TEXT")
    private   String address;
    private Float salary;
    private Date joiningDate;
    private File file;
}