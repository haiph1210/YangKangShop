package com.YangKang.service;

import com.YangKang.entity.Category;
import com.YangKang.form.CategoryCreateForm;
import com.YangKang.form.CategoryFilterForm;
import com.YangKang.form.CategoryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable, CategoryFilterForm form);

    Category findById(Integer id);

    Category findByName(String name);

    void create(CategoryCreateForm form);

    void update(CategoryUpdateForm form);

    void deleleById(Integer id);

    void deleteAll(List<Integer> ids);
}
