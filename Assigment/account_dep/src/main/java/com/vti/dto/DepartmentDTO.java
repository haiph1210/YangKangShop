package com.vti.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
@Getter
@Setter
public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {
    private Integer id;
    private String name;
    private String type;
    private List<AccountDTO> accounts;

    public static class AccountDTO extends RepresentationModel<AccountDTO>{
            private Integer id;
            private String username;
    }
}
