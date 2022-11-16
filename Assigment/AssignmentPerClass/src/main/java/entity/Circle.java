package entity;

import javax.persistence.*;

@Entity
@Table(name = "circle")
@AttributeOverrides( value = {
        @AttributeOverride(name = "id",column = @Column(name = "id")),
        @AttributeOverride(name = "namme",column = @Column(name = "name"))
}
)
public class Circle extends Shape {
    @Column(name = "radius")
    private Double radius;

    public Circle() {
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
                "radius=" + radius +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
