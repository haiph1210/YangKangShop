package com.YangKang.service;

import com.YangKang.entity.Category;
import com.YangKang.entity.Product;
import com.YangKang.form.CategoryCreateForm;
import com.YangKang.form.CategoryFilterForm;
import com.YangKang.form.CategoryUpdateForm;
import com.YangKang.repository.ICategoryRepository;
import com.YangKang.repository.IProductRepository;
import com.YangKang.specifition.CategorySpeacifition;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Category> findAll(Pageable pageable, CategoryFilterForm form){
        Specification<Category> specification = CategorySpeacifition.buildWhere(form);
        return repository.findAll(specification,pageable);
    }

    @Override
    public Category findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category findByName(String name){
        return repository.findByName(name);
    }

    @Override
    public void create(CategoryCreateForm form){
        Category category = mapper.map(form,Category.class);
        List<Product> products = category.getProducts();
        if (products != null){
            for (Product product : products) {

                if (product.getSalePrice() == 0){
                    Double money = product.getPrice() * product.getAmount();
                    product.setMoney(money);
                }else {
                    Double moneySalePrice = Double.valueOf(product.getSalePrice());
                    Double moneySale = product.getPrice() * product.getAmount() - (product.getPrice() * product.getAmount() * (1/moneySalePrice));
                    product.setMoney(moneySale);
                }

                product.setCategory(category);
            }
        }
        repository.save(category);
        productRepository.saveAll(products);

    }

    @Override
    public void update(CategoryUpdateForm form){
        Category category = mapper.map(form,Category.class);
        repository.save(category);


    }

    @Override
    public void deleleById(Integer id){
        repository.deleteById(id);
    }
    @Override
    public void deleteAll(List<Integer> ids){
        repository.deleteAllById(ids);
    }

}
