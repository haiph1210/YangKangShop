package com.vti.entity;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends Person{
    @Column(name = "score")
    @ColumnDefault("0.0")
    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
