import entity.Circle;
import entity.Rectangle;
import repository.ShapeRepository;
import utils.HibernateUtils;

import java.util.List;

public class program {
    public static void main(String[] args) {
        ShapeRepository repository  = new ShapeRepository();

        repository.createCircle(new Circle("Circle1",10.4 ));
        repository.createCircle(new Circle("Circle1",10.4 ));
        repository.createCircle(new Circle("Circle1",10.4 ));
        repository.createCircle(new Circle("Circle1",10.4 ));
        repository.createCircle(new Circle("Circle1",10.4 ));
        repository.createRectangle(new Rectangle("Rectangle1",10.5,2.4));
        repository.createRectangle(new Rectangle("Rectangle1",10.5,2.4));
        repository.createRectangle(new Rectangle("Rectangle1",10.5,2.4));
        repository.createRectangle(new Rectangle("Rectangle1",10.5,2.4));

        for (Circle circle : repository.findAllCircle()) {
            System.out.println("circle = " + circle);
        }

        System.out.println("==================================");
        for (Rectangle rectangle : repository.findAllRectangle()) {
            System.out.println("rectangle = " + rectangle);
        }
    }
 }
