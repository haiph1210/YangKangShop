package com.vti.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class StudentCreateForm {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String classz;
    private List<Group> groups;
    @Getter
    @Setter
    public static class Group{
        private String name;
    }
}
