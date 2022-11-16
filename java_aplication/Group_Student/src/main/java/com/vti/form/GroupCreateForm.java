package com.vti.form;

import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.Setter;
import sun.security.mscapi.CPublicKey;

import java.util.List;
@Getter
@Setter
public class GroupCreateForm {
    private String name;
//    private Integer studentId;
    private List<Student> students;
    @Getter
    @Setter
    public static class Student{
        private String name;
        private String email;
        private String password;
        private String phone;
        private String address;
        private String classz;
    }
}
