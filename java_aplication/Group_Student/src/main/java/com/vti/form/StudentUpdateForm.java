package com.vti.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateForm {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String classz;
    private Integer groupId;
}
