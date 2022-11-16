package com.VTI;

import com.VTI.entity.Department;
import com.VTI.repository.DepartmentRepository;

public class DepartmentProgram {
    public static void main(String[] args) {
        DepartmentRepository  repository = new DepartmentRepository();
        System.out.println("--------------- CREATE ---------------");
        repository.create(new Department("HR 1"));
        repository.create(new Department("HR 2"));
        repository.create(new Department("HR 3"));
        repository.create(new Department("HR 4"));
        repository.create(new Department("HR 5"));
        repository.create(new Department("HR 6"));

        System.out.println("repository.findById(1) = " + repository.findByID(1));
        System.out.println("repository.findByName(\"HR 2\") = " + repository.findByName("HR 2"));
        System.out.println("repository.update(1, \"HR 7\") = " + repository.update(1, "HR 7"));
        System.out.println("repository.deleteById(2) = " + repository.deleteByID(2));
        System.out.println("repository.deleteByName(\"HR 6\") = " + repository.deleteByName("HR 6"));
        for (Department department : repository.findAllWithPaging(2, 2)) {
            System.out.println("department = " + department);
        }

    }
}
