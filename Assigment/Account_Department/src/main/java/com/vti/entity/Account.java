package com.vti.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table

@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false,unique = true,length = 50)
    private String email;
    @Column(nullable = false,length = 50)
    private String firstName;
    @Column(nullable = false,length = 50)
    private String lastName;
    @Formula("concat(first_name,' ',last_name)")
    private String fullName;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDate createDate;
    @UpdateTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime updateAt;
    public enum Department{
        ADMIN,MANAGER,EMPLOYEE
    }
}
