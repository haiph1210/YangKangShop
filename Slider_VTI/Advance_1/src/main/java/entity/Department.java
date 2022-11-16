package entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "department")
public class Department {
    @Id
    @Column(name = "id")   // column id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng
    private int id;

    @Column(name = "name", length = 50, unique = true, nullable = false)  // tạo column name chiều dài 50
    // có unique và ko null
    private String name;

    @Column(name = "create_date", nullable = false, updatable = false ) // updatable laf ko cho update
    @CreationTimestamp // creat thời gian theo thời gian tạo
    private LocalDate createdDate;

    @Column(name = "updated_at", nullable = false ,updatable = false)
    @UpdateTimestamp // update tự động
    private LocalDateTime  updatatedAt;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(int id, String name) {
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatatedAt() {
        return updatatedAt;
    }

    public void setUpdatatedAt(LocalDateTime updatatedAt) {
        this.updatatedAt = updatatedAt;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", updatatedAt=" + updatatedAt +
                '}';
    }
}
