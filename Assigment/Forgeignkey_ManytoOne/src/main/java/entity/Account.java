package entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "name",length = 50,unique = true,nullable = false)
    private  String  name;
    @Column(name = "email",length = 50)
    private String email;
    @Column(name = "address",length = 20)
    private Address  address;
    @Column(name = "create_date",updatable = false)
    @CreationTimestamp
    private LocalDate createDate;
    @Column(name = "update_at",updatable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id",nullable = false)
    private Department department;

    public Account() {
    }

    public Account(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Account(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
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

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", createDate=" + createDate +
                ", updateAt=" + updateAt +
                ", department=" + department.getName() +
                '}';
    }

    public enum Address{
        HANOI,NINHBINH,HOCHIMINH
    }
}
