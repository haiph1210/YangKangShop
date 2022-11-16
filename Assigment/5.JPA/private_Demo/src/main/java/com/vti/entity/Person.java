package com.vti.entity;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    protected String email;

    @Column(name = "name", nullable = false, length = 50)
    protected String name;
    @Column(name = "gender", length = 7, nullable = false)
    @Enumerated(EnumType.STRING)
    protected Gender gender;

    public enum Gender {
        MALE, FEMALE, UNKNOWN
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
