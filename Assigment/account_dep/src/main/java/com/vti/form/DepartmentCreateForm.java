package com.vti.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DepartmentCreateForm {
    public String name;
    private String type;
    private Integer totalMembers;
    private List<Account> accounts;
    @Getter
    @Setter
    public static class Account{
        private String username;
    }
}
