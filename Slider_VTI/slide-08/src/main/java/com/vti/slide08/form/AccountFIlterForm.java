package com.vti.slide08.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class AccountFIlterForm {
    private String search;
    private Integer  minId;
    private Integer  maxId;

}
