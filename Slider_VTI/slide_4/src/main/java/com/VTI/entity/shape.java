package com.VTI.entity;

import javax.persistence.*;

//@Entity
//@Table(name = "shape")
//@DiscriminatorColumn(name = "type",discriminatorType = DiscriminatorType.STRING)
// TH1
//@Entity
//@Table(name = "shape")
//@Inheritance(strategy = InheritanceType.JOINED) TH3
@MappedSuperclass
public class shape {
    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(name = "name", length = 50, nullable = false)
    protected String name;

    public shape() {
    }

    public shape(String name) {
        this.name = name;
    }

    public shape(Integer id, String name) {
        this.id = id;
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
        return "shape{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
