package com.YangKang.dto;

import com.YangKang.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDTO extends RepresentationModel<ProductDTO> {
    private Integer id;
    private String name;
    private Integer salePrice;
    private Double price;
    private Product.Ram ram;
    private String thumbnailUrl;
    private String description;
    private Integer amount;
    private Double money;
    private LocalDate createdDate;
    private LocalDateTime updateAt;
    private String categoryName;
}
