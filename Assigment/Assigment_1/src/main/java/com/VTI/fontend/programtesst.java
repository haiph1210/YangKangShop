package com.VTI.fontend;

import com.VTI.entity.Group;
import com.VTI.repository.GroupRepository;

public class programtesst {
    public static void main(String[] args) {
        GroupRepository repository = new GroupRepository();
        System.out.println("=========================show=============================");
        repository.create(new Group("Hải"));
    }
}
