package com.VTI.entity;

import javax.persistence.*;

@Entity
//@DiscriminatorValue(value = "C")// cột phân biệt

@Table(name = "circle")
//@AttributeOverrides(
//        value = {
//                @AttributeOverride(name = "id",column = @Column(name = "id")),
//                @AttributeOverride(name = "name",column = @Column(name = "circle_name")),
//        }
//)  TH2

//@PrimaryKeyJoinColumn(name = "id")
public class Circle extends shape {
    @Column(name = "radius",nullable = true)
    private Double radius;

    public Circle() {
    }

    public Circle(Integer id, String name, Double radius) {
        super(id, name);
        this.radius = radius;
    }

    public Circle(String name, Double radius) {
        super(name);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +

                ", id=" + id +
                ", name='" + name + '\'' +
                "radius=" + radius +
                '}';
    }
}
