package com.VTI;

import com.VTI.entity.Circle;
import com.VTI.entity.Rectangle;
import com.VTI.repository.ShapeRepository;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        ShapeRepository repository = new ShapeRepository();
        System.out.println("+===================  Create  ===============================+");
        repository.createCircle(new Circle(1,"Circle",10.5));
        repository.createCircle(new Circle(2,"Circle",10.5));
        repository.createRectangle(new Rectangle(10,"Rectangle",4.55,5.5));
        repository.createRectangle(new Rectangle(1000,"Rectangle",4.55,5.5));
        System.out.println("+===================  ShowAll ===============================+");
        for (Circle allCircle : repository.findAllCircles()) {
            System.out.println("allCircle = " + allCircle);
        }
        for (Rectangle allRectangle : repository.findAllRectangles()) {
            System.out.println("allRectangle = " + allRectangle);
        }
    }
}
