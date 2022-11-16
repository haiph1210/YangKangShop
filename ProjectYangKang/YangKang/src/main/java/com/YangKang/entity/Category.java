package com.YangKang.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",length = 50,nullable = false,unique = true)
    private String name;
    @Column(name = "created_date",nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;
    @Column(name = "update_at",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @OneToMany(mappedBy = "category",cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    private List<Product> products;
}
