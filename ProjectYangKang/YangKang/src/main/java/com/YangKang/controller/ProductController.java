package com.YangKang.controller;

import com.YangKang.dto.ProductDTO;
import com.YangKang.entity.Product;
import com.YangKang.form.ProductCreateForm;
import com.YangKang.form.ProductFilterForm;
import com.YangKang.form.ProductUpdateForm;
import com.YangKang.service.IProductService;
import com.YangKang.validation.ProductExistsById;
import com.YangKang.validation.ProductExistsByName;
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
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private IProductService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable, ProductFilterForm form){
        Page<Product> page = service.findAll(pageable,form);
        List<Product> products = page.getContent();
        List<ProductDTO> dtos = mapper.map(products,new TypeToken<List<ProductDTO>>(){}.getType());
        for (ProductDTO dto : dtos) {
            dto.add(
                    linkTo(
                            methodOn(CategoryController.class).findById(dto.getId())

                    ).withSelfRel());
            }
        return new PageImpl<>(dtos,pageable,page.getTotalPages());
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable @ProductExistsById Integer id){
        Product product = service.findById(id);
        return mapper.map(product,ProductDTO.class);
    }

    @GetMapping("/name/{name}")
    public ProductDTO findByName(@PathVariable @ProductExistsByName String name){
        Product product = service.findByName(name);
        return mapper.map(product,ProductDTO.class);
    }

    @PostMapping()
    public void create(@RequestBody @Valid ProductCreateForm form){
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable @ProductExistsById Integer id,@RequestBody @Valid ProductUpdateForm form){
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleleById(@PathVariable @ProductExistsById  Integer id){
        service.deleleById(id);
    }

    @DeleteMapping
    public void deleteAll(@RequestBody List<@ProductExistsById Integer> ids){
        service.deleteAll(ids);
    }
}
