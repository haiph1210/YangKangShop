package com.YangKang.form;

import com.YangKang.entity.Account;
import com.YangKang.validation.AccountNotExistsByUserName;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class AccountCreateForm {
    @NotBlank(message = "{AccountForm.username.NotBlank}")
    @Length(max = 50,message = "{AccountForm.username.Lenght}")
    @AccountNotExistsByUserName
    private String username;
    @NotBlank(message = "{AccountForm.password.NotBlank}")
    @Length(max =100,message = "{AccountForm.password.Length}")
    private String password;
    @NotBlank(message = "{AccountForm.firstName.NotBlank}")
    @Length(max = 30, message = "{AccountForm.firstName.Length}")
    private String firstName;
    @NotBlank(message = "{AccountForm.lastName.NotBlank}")
    @Length(max = 30, message = "{AccountForm.lastName.Length}")
    private String lastName;
    @Pattern(
            regexp = "ADMIN||MANAGER||CLIENT",
            message = "{AccountForm.role.NotNull}"
    )
    private Account.Role role;
}
