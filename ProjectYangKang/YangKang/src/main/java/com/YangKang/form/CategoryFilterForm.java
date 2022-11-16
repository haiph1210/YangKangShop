package com.YangKang.form;

import com.YangKang.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CategoryFilterForm {
    private String search;
    private LocalDate createdDate;
    private LocalDate minCreatedDate;
    private LocalDate maxCreatedDate;
    private Integer year;
}
