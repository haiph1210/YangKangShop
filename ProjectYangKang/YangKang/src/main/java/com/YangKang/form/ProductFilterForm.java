package com.YangKang.form;

import com.YangKang.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ProductFilterForm {
    private String search;  // search name product and  search name category
    private Double price;
    private Product.Ram ram;
    private LocalDate createdDate;
    private LocalDate minCreatedDate;
    private LocalDate maxCreatedDate;
    private Integer year;
}
