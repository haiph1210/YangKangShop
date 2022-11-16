package com.vti.form;


import com.vti.entity.Account;
import com.vti.validation.DepartmentNameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.List;

@Getter
@Setter
public class DepartmentCreateForm {
    @NotBlank(message = "{Department.createDepartment.form.name.NotBlank}")
    @Length(max = 20,message = "{Department.createDepartment.form.name.Length}")
    @DepartmentNameNotExists(message = "{Department.createDepartment.form.name.NotExists}")
    private String name;
    @NotNull(message = "notnull")
    @Pattern(
            regexp = "DEV||TEST||SM||PM",
            message = "Nhập DEV, TEST,SM or PM"
    )
    private String type;
    private Integer totalMembers;
//    private Account account;

//    private Integer accountId;
//    private List< Account> accounts;
//    @Getter
//    @Setter
//    public static class Account{
//
//        private String username;
//        private String password;
//        private String firstName;
//        private String lastName;
//        private String role;
//    }
}
