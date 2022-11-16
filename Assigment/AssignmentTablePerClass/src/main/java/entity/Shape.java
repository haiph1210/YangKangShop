package entity;

import javax.persistence.*;

@MappedSuperclass

public class Shape {
    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(name = "name",nullable = false, length = 50)
    protected String name;

    public Shape() {
    }

    public Shape(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Shape(String name) {
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

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
