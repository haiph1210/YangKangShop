package com.vti.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Account {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true,length = 50)
    private String username;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id",nullable = false)
    private Department department;

}
