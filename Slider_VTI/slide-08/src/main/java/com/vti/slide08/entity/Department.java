package com.vti.slide08.entity;

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
    @Column(nullable = false,unique = true,length = 50)
    private String name;
    @Column(nullable = false)
    private Double totalMembers;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 16)
    private Type type;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDate createdDate;

    @OneToMany(mappedBy = "department",cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    private List<Account> accounts;

    public enum Type {
        DEVELOPER,TESTER,SCRUM_MASTER,PROJECT_MANAGER
    }
}
