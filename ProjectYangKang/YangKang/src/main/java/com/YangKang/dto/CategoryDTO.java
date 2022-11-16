package com.YangKang.dto;

import com.YangKang.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CategoryDTO extends RepresentationModel<CategoryDTO> {
    private Integer id;
    private String name;
    private LocalDate createdDate;
    private LocalDateTime updateAt;
    private List<ProductDTO> products;
    @Getter
    @Setter
    public static class ProductDTO extends  RepresentationModel<ProductDTO>{
        private Integer id;
        private String name;
        private Product.Ram ram;
    }
}
