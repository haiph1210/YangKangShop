package com.vti.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
@Getter
@Setter

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 50,nullable = false,unique = true)
    private String username;
    @Column(length = 80,nullable = false)
    private String password;
    @Column(length = 80,nullable = false)
    private String firstName;
    @Column(length = 80,nullable = false)
    private String lastName;
    @Formula("concat(first_name,' ',last_name )")
    private String fullName;
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id",nullable = false)
    private Department department;



    public enum Role{
        ADMIN,MANAGER,EMPLOYEE
    }
}
