package com.vti.slide08.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

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
    @Column(nullable = false,length = 72)
    private String password;
    @Column(nullable = false,length = 50)
    private String firstName;
    @Column(nullable = false,length = 50)
    private String lastName;
    @Formula("concat(first_name,' ',last_name)")
    private String fullName;
    @Column(nullable = false,length = 8)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id",nullable = false)
    private Department department;

    public enum Role{
        ADMIN,MANAGER,EMPLOYEE
    }
}
