import entity.Department;
import repository.DepartmentRepository;

import java.util.List;

public class program {
    public static void main(String[] args) {
        DepartmentRepository repository = new DepartmentRepository();


        System.out.println("=======================Create =============================");
        repository.create(new Department("Java Basic"));
        repository.create(new Department("Java Advance"));
        repository.create(new Department("Java Fontend"));

        System.out.println("=======================Show All=============================");
        List<Department> groups = repository.findAll();
        for (Department group : groups) {
            System.out.println("group = " + group);
        }

        System.out.println("=======================Show BY ID=============================");
        Department department = repository.findByID(2);
        System.out.println("department = " + department);

        System.out.println("=======================Update =============================");
        repository.update(new Department(1,"SQL"));

        System.out.println("=======================Delete =============================");
        repository.deletebyID(3);


        System.out.println("=======================Show All- 2=============================");
        List<Department> ds = repository.findAll();
        for (Department d : ds) {
            System.out.println("d = " + d);
        }

    }
 }
