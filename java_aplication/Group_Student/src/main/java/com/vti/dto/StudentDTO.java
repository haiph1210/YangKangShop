package com.vti.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class StudentDTO {
    private String name;
    private String email;
//    private String password;
    private String phone;
    private String address;
    private String classz;
    private String groupName;
//    private List<GroupDTO> groups;
//        @Getter
//        @Setter
//    public static class GroupDTO{
//        private String name;
//    }
}
