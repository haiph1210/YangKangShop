package com.YangKang.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Getter
@Setter
@Data
public class Account {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username",length = 50,unique = true,nullable = false)
    private String username;
    @Column(name = "password",length = 100,nullable = false)
    private String password;
    @Column(name = "first_name",length = 30,nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 30,nullable = false)
    private String lastName;
    @Formula("concat(first_name , ' ' , last_name)")
    @Column(name = "full_name")
    private String fullName;
    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false,length = 8)
    private Role role;
    @Column(name = "created_date",updatable = false,nullable = false)
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    @Column(name = "update_at",nullable = false)
    private LocalDateTime updateAt;

    public enum Role{
        ADMIN,MANAGER,CLIENT
    }

}
