package com.YangKang.service;

import com.YangKang.entity.Product;
import com.YangKang.form.ProductCreateForm;
import com.YangKang.form.ProductFilterForm;
import com.YangKang.form.ProductUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable, ProductFilterForm form);

    Product findById(Integer id);

    Product findByName(String name);

    void create(ProductCreateForm form);

    void update(ProductUpdateForm form);

    void deleleById(Integer id);

    void deleteAll(List<Integer> ids);
}
