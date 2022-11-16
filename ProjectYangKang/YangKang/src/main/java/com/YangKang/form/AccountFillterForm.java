package com.YangKang.form;

import com.YangKang.entity.Account;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccountFillterForm {
    // like
    private String search;
    // equal
    private Account.Role role;
    // equal
    private LocalDate createdDate;
    // lessthan
    private LocalDate minCreatedDate;
    // greaterthan
    private LocalDate maxCreatedDate;
    // equal
    private Integer year;
}
