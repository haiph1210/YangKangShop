package com.YangKang.dto;

import com.YangKang.entity.Account;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class AccountDTO {
    private Integer id;
    private String username;
    private String fullName;
    private Account.Role role;
    private LocalDate createdDate;
    private LocalDateTime updateAt;

}
