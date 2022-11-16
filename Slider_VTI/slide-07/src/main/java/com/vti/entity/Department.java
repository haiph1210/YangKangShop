package com.vti.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor  //contructor ko tham số
@AllArgsConstructor // contructor full tham số
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @Column(nullable = false,unique = true,length = 50)
    private String name;
    @Column(nullable = false)
    private Integer totalMembers;
}
