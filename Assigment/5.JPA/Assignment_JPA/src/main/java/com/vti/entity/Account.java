package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(name = "address", length = 50, nullable = false)
    private Address address;
    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate createDate;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public enum Address {
        HA_NOI, NINH_BINH, HO_CHI_MINH
    }
}
