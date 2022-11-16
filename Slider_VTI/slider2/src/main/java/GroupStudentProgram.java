
import entity.GroupStudent;
import repository.GroupStudentRepository;

import java.util.List;

public class GroupStudentProgram {
    public static void main(String[] args) {
        GroupStudentRepository student = new GroupStudentRepository();
        System.out.println("=============created==============");
        student.create(new GroupStudent(1,1));
        student.create(new GroupStudent(1,2));
        student.create(new GroupStudent(2,1));
        student.create(new GroupStudent(2,2));
        System.out.println("===============Show===================");
        List<GroupStudent> groupStudents = student.getAll();
        for (GroupStudent groupStudent : groupStudents) {
            System.out.println("groupStudent = " + groupStudent);
        }
        }
}
