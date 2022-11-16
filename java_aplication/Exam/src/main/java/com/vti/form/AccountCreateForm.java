package com.vti.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class AccountCreateForm {
    @NotBlank(message = "{AccountForm.username.NotBlank}")
    @Length(max = 50, message = "{AccountForm.username.Length}")
    private String username;
    @NotBlank(message = "{AccountForm.password.NotBlank}")
    @Length(max = 32, message = "{AccountForm.password.Length}")
    private String password;
    @NotBlank(message = "{AccountForm.firstName.NotBlank}")
    @Length(max = 50, message = "{AccountForm.firstName.Length}")
    private String firstName;
    @NotBlank(message = "{AccountForm.lastName.NotBlank}")
    @Length(max = 50, message = "{AccountForm.lastName.Length}")
    private String lastName;
    @NotNull(message = "{AccountForm.role.NotNull}")
    @Pattern(
            regexp = "ADMIN||MANAGER||EMPLOYEE",
            message = "Nhập ADMIN, MANAGER or EMPLOYEE"
    )
    private String role;
    private Integer departmentId;

}
