package com.VTI.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "group")
public class Group {
 @Id
 @Column(name = "id")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 @Column(name = "name",length = 50, nullable = false, unique = true)
    private String name;
 @Column(name = "created_Date",nullable = false,updatable = false)
 @CreationTimestamp
    private LocalDate createDate;
 @Column(name = "updated_at",nullable = false,updatable = false)
 @UpdateTimestamp
    private LocalDateTime updatedAt;
 @Column(name = "type",nullable = false)
 @Enumerated(value = EnumType.ORDINAL) // theo số
    private Type type;
    public enum Type{
        DEVELOPER , TESTER ,SCRUM, PROJECT
    }
    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
