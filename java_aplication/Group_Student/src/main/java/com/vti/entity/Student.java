package com.vti.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
@Getter
@Setter
public class Student {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(length = 50,unique = true,nullable = false)
    private String email;
    @Column(length = 50,nullable = false)
    private String password;
    @Column(length = 50,nullable = false)
    private String phone;
    @Column(length = 12,nullable = false)
    private String address;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Classz classz;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "group_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;
    public enum Classz{
        PRESCHOOL,PRIMARY_SCHOOL,HIGH_SCHOOL,UNIVERSITY

        }
}
