package com.vti.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentUpdateForm {
    private Integer id;
    private String name;
    private String type;
    private Integer totalMembers;
}

