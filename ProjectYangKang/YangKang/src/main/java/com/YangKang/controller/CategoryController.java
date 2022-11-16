package com.YangKang.controller;

import com.YangKang.dto.CategoryDTO;
import com.YangKang.entity.Category;
import com.YangKang.form.CategoryCreateForm;
import com.YangKang.form.CategoryFilterForm;
import com.YangKang.form.CategoryUpdateForm;
import com.YangKang.service.ICategoryService;
import com.YangKang.validation.CategoryExistsById;
import com.YangKang.validation.CategoryExistsByName;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Validated
@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<CategoryDTO> findAll(Pageable pageable, CategoryFilterForm form){
        Page<Category> page = service.findAll(pageable,form);
        List<Category> categories = page.getContent();
        List<CategoryDTO> dtos = mapper.map(categories,new TypeToken< List<CategoryDTO>>(){}.getType());
        for (CategoryDTO dto : dtos) {
            dto.add(
                    linkTo(
                            methodOn(CategoryController.class).findById(dto.getId())
                    ).withSelfRel()
            );
            for (CategoryDTO.ProductDTO product : dto.getProducts()) {
                product.add(
                        linkTo(
                                methodOn(ProductController.class).findById(product.getId())
                        ).withSelfRel()
                );
            }
        }
        return new PageImpl<>(dtos,pageable,page.getTotalPages());
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable @CategoryExistsById  Integer id){
        Category category = service.findById(id);
        return mapper.map(category,CategoryDTO.class);
    }

    @GetMapping("/name/{name}")
    public CategoryDTO findByName(@PathVariable @CategoryExistsByName String name){
        Category category = service.findByName(name);
        return mapper.map(category,CategoryDTO.class);
    }

    @PostMapping()
    public void create(@RequestBody @Valid CategoryCreateForm form){
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable @CategoryExistsById Integer id,@RequestBody @Valid  CategoryUpdateForm form){
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleleById(@PathVariable @CategoryExistsById Integer id){
        service.deleleById(id);
    }

    @DeleteMapping
    public void deleteAll(@RequestBody List<@CategoryExistsById Integer> ids){
        service.deleteAll(ids);
    }

}
