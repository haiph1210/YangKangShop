package com.YangKang.form;

import com.YangKang.entity.Account;
import com.YangKang.validation.AccountExistsById;
import com.YangKang.validation.AccountNotExistsByUserName;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class AccountUpdateForm {
    @AccountExistsById   // ID ko tồn tại
    private Integer id;
    @AccountNotExistsByUserName //  tên tài khoản đã tồn tại
    @NotBlank(message = "{AccountForm.password.NotBlank}")
    @Length(max =100,message = "{AccountForm.password.Length}")
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
            regexp = "ADMIN || MANAGER || CLIENT",
            message = "{AccountForm.role.NotNull}"
    )
    private Account.Role role;


}
