package com.VTI.fontend;

import com.VTI.entity.Group;
import com.VTI.repository.GroupRepository;
import com.VTI.utils.HibernateUtils;

import java.util.List;
import java.util.Scanner;

public class FunctionProgram {
    private Scanner scanner;
    private GroupRepository repository ;

    public FunctionProgram() {
        repository = new GroupRepository();
        scanner = new Scanner(System.in);
    }
    public void showAll(){
        List<Group> groups = repository.findAll();
        for (Group group : groups) {
            System.out.println("group = " + group);
        }
        HibernateUtils.closeFactory();
    }
    public void showByID(){
        System.out.println("Nhập vào ID cần tìm");
        int id = scanner.nextInt();
        Group group = repository.findByID(id);
        System.out.println("group = " + group);
        HibernateUtils.closeFactory();
    }
    public void showByName(){
        System.out.println("Nhập vào name cần tìm");
        String name = scanner.nextLine();
        Group group = repository.findByName(name);
        System.out.println("group = " + group);
        HibernateUtils.closeFactory();
    }
    public void createGroup(){
        System.out.println("Nhập vào tên Group cần tạo:");
        String name = scanner.nextLine();
        repository.create(new Group(name));
        HibernateUtils.closeFactory();
    }
    public void updateGroup(){
        System.out.println("Nhập ID cần tìm: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập Name thay đổi: ");
        String name = scanner.nextLine();
        repository.update(new Group(id,name));
        HibernateUtils.closeFactory();
    }
    public void deleteGroup(){
        System.out.println("Nhập ID cần xóa: ");
        int id = scanner.nextInt();
        repository.deleteByID(id);
        HibernateUtils.closeFactory();
    }

}
