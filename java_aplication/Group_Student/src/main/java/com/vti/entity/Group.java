package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false,length = 50,unique = true)
    private String name;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;
    @ManyToMany(mappedBy = "groups")
    @JsonBackReference
    private List<Student> students;


}
