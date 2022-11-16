package com.vti.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private Integer totalMembers = 0; // số người luôn là 1 số nguyên > 0 => kiểu int là ok
    // và để mặc điịnh là 1 vì phòng ban nào cũng phải có ít nhát 1 người, k thể phòng ban k có ai
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 5)
    private Type   type;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @OneToMany(mappedBy = "department",cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    private List<Account> accounts;
    public enum Type{
            DEV,TEST,SM,PM
    }
}
