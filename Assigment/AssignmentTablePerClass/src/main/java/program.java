import entity.Circle;
import entity.Rectangle;
import repository.ShapeRepository;

public class program {
    public static void main(String[] args) {
        ShapeRepository repository  = new ShapeRepository();

        repository.createCircle(new Circle(1,"Circle1",10.4 ));
        repository.createCircle(new Circle(2,"Circle1",10.4 ));
        repository.createCircle(new Circle(3,"Circle1",10.4 ));
        repository.createCircle(new Circle(4,"Circle1",10.4 ));
        repository.createCircle(new Circle(5,"Circle1",10.4 ));
        repository.createRectangle(new Rectangle(10,"Rectangle1",10.5,2.4));
        repository.createRectangle(new Rectangle(20,"Rectangle1",10.5,2.4));
        repository.createRectangle(new Rectangle(50,"Rectangle1",10.5,2.4));
        repository.createRectangle(new Rectangle(70,"Rectangle1",10.5,2.4));

        for (Circle circle : repository.findAllCircle()) {
            System.out.println("circle = " + circle);
        }

        System.out.println("==================================");
        for (Rectangle rectangle : repository.findAllRectangle()) {
            System.out.println("rectangle = " + rectangle);
        }
    }
 }
