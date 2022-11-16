package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class GroupDTO {
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

//    @Getter
//    @Setter
//    public static class StudentDTO{
//        private String name;
//        private String email;
//        private String phone;
//        private String classz;
//    }
}
