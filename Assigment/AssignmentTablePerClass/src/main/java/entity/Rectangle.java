package entity;

import javax.persistence.*;

@Entity
@Table(name = "rectangle")
@PrimaryKeyJoinColumn(name = "id")
public class Rectangle extends Shape{
    private Double width;
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
