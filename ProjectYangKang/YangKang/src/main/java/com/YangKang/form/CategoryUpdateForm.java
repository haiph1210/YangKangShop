package com.YangKang.form;

import com.YangKang.validation.CategoryExistsById;
import com.YangKang.validation.CategoryNotExistsByName;
import com.YangKang.validation.ProductNotExistsByName;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryUpdateForm {
    @CategoryExistsById // idd ko tồn tại
    private Integer id;
    @CategoryNotExistsByName // tên danh mục đã tồn tại
    @NotBlank(message = "{CategoryForm.name.NotBlank}")
    @Length(message = "{CategoryForm.name.Lenght}")
    private String name;
}
