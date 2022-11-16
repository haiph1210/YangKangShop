package com.vti.slide08.form;

import com.vti.slide08.validation.DepartmentNameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class DepartmentCreateForm {
    @NotBlank(message = "{Department.createDepartment.form.name.NotBlank}")
    @Length(max = 50, message = "{Department.createDepartment.form.name.Length}")
    @DepartmentNameNotExists(message = "{Department.createDepartment.form.name.NotExists}")
    private String name;
    @NotNull(message = "Department total members must NOT be null")
    @PositiveOrZero(message = "Department total members must be greater than or equal 0")
    private Integer totalMembers;
    @Pattern(
            regexp = "DEVELOPER|TESTER|SCRUM_MASTER|PROJECT_MANAGER",
            message = "Department type must be DEVELOPER, TESTER, SCRUM_MASTER or PROJECT_MANAGER"
    )

    private String type;
//    @NotEmpty
    private List<@Valid Account> accounts;
    @Getter
    @Setter
    public static class Account{
       @NotBlank(message = "accoutn username not blank")
       @Length(max = 50, message = "Account name's length is max 50 characters")

        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String role;

    }
}
