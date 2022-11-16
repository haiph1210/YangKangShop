package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Department(String name) {
        this.name = name;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

//    @Override
//    public String toString() {
//        return "Department{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", accounts=" + accounts +
//                '}';
//    }
}
