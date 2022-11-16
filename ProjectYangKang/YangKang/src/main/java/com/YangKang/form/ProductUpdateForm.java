package com.YangKang.form;

import com.YangKang.entity.Product;
import com.YangKang.validation.CategoryExistsById;
import com.YangKang.validation.ProductExistsById;
import com.YangKang.validation.ProductNotExistsByName;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter

public class ProductUpdateForm {
    @ProductExistsById // id ko tồn tại
    private Integer id;
    @ProductNotExistsByName // tên sản phẩm đã tồn tại
    @NotBlank(message = "{ProductForm.name.NotBlank}")
    @Length(max = 50,message = "{ProductForm.name.Lenght}")
    private String name;
    private Double salePrice;
    @NotNull(message = "{ProductForm.price.NotNull}")
    private Double price;
    @Pattern(
            regexp = " _4GB || _8GB || _16GB || _32GB || _64GB || _128GB || _256GB || _1TB"
            ,message =  "{ProductForm.ram.NotNull}"
    )
    @Length(max = 6, message = "{ProductForm.ram.Lenght}")
    private com.YangKang.entity.Product.Ram ram;
    @NotNull(message = "{ProductForm.thumbnailUrl.NotNull}")
    private String thumbnailUrl;
    @NotNull(message = "{ProductForm.description.NotNull}")
    private String description;
    @NotNull(message = "{ProductForm.amount.NotNull}")
    private Integer amount;
    @CategoryExistsById // id danh mục ko tồn tại
    private Integer categoryId;
}
