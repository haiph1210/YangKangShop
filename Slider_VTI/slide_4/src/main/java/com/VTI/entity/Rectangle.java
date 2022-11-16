package com.VTI.entity;

import javax.persistence.*;

@Entity
//@DiscriminatorValue(value = "R")

@Table(name = "rectangle")

//@AttributeOverrides(
//        value = {
//                @AttributeOverride(name = "id",column = @Column(name = "id")),
//                @AttributeOverride(name = "name",column = @Column(name = "rectangle_name")),
//        }
//)

//@PrimaryKeyJoinColumn(name = "id")

public class Rectangle extends shape{
    @Column(name = "width")
    private Double width;
    @Column(name = "height")
    private Double height;

    public Rectangle() {
    }

    public Rectangle(Integer id, String name, Double width, Double height) {
        super(id, name);
        this.width = width;
        this.height = height;
    }

    public Rectangle(String name, Double width, Double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
