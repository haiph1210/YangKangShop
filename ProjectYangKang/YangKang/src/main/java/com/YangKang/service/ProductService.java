package com.YangKang.service;

import com.YangKang.entity.Product;
import com.YangKang.form.ProductCreateForm;
import com.YangKang.form.ProductFilterForm;
import com.YangKang.form.ProductUpdateForm;
import com.YangKang.repository.IProductRepository;
import com.YangKang.specifition.ProductSpeacifition;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Product> findAll(Pageable pageable, ProductFilterForm form){
        Specification<Product> specification = ProductSpeacifition.buildWhere(form);
        return repository.findAll(specification,pageable);
    }

    @Override
    public Product findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product findByName(String name){
        return repository.findByName(name);
    }

    @Override
    public void create(ProductCreateForm form)
    {
        Product product = mapper.map(form,Product.class);

        if (product.getSalePrice() == 0){
            Double money = product.getPrice() * product.getAmount();
              product.setMoney(money);
        }else {
            Double moneySalePrice = Double.valueOf(product.getSalePrice());
            Double moneySale = product.getPrice() * product.getAmount() - (product.getPrice() * product.getAmount() * (1/moneySalePrice));
            product.setMoney(moneySale);
        }
        repository.save(product);

    }

    @Override
    public void update(ProductUpdateForm form){
        Product product = mapper.map(form,Product.class);
        if (product.getSalePrice() == 0){
            Double money = product.getPrice() * product.getAmount();
            System.out.printf("%.3f",money);
            product.setMoney(money);
        }else {
            Double moneySalePrice = Double.valueOf(1 / product.getSalePrice());
            Double moneySale = product.getPrice() * product.getAmount() - (product.getPrice() * product.getAmount() * moneySalePrice);
            System.out.printf("%.3f",moneySale);
            product.setMoney(moneySale);
        }
        repository.save(product);
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
