package com.YangKang.specifition;

import com.YangKang.entity.Account;
import com.YangKang.entity.Product;
import com.YangKang.form.ProductFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class ProductSpeacifition {
    public static Specification<Product> buildWhere(ProductFilterForm form){

            if (form == null) {
                return null;
            }
            return hasNameProductLike(form.getSearch()).or(hasNameCategoryLike(form.getSearch())
                    .and(hasPriceLessThanEqualTo(form.getPrice())
                            .and(hasRamLessThanEqualTo(form.getRam())
                                    .and(hasCreatedDateEqual(form.getCreatedDate())
                                            .and(hasMinCreatedDateGenterThanEqualTo(form.getMinCreatedDate())
                                                    .and(hasMaxCreatedDateLessThanOrEqualTo(form.getMaxCreatedDate())
                                                            .and(hasYearEqual(form.getYear()))))))));

    }


    private static Specification<Product> hasNameProductLike(String search){
        return (root, query, builder) -> {
            if (!StringUtils.hasText(search)){
                return null;
            }
            return builder.like(root.get("name"), "%"+ search +"%" );
        };
    }
    private static Specification<Product> hasNameCategoryLike(String search){
        return (root, query, builder) -> {
            if (!StringUtils.hasText(search)){
                return null;
            }return builder.like(root.get("category").get("name"),"%"+ search +"%");
        };
    }

    private static Specification<Product> hasCreatedDateEqual(LocalDate createdDate){
        return (root, query, builder) -> {
            if (createdDate == null){
                return null;
            }
            return builder.equal(root.get("createdDate").as(LocalDate.class),createdDate);
        };
    }
    private static Specification<Product> hasMinCreatedDateGenterThanEqualTo(LocalDate minCreatedDate){
        return (root, query, builder) -> {
            if (minCreatedDate == null){
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get("createdDate").as(LocalDate.class),minCreatedDate);
        };
    }
    private static Specification<Product> hasMaxCreatedDateLessThanOrEqualTo(LocalDate maxCreatedDate){
        return (root, query, builder) -> {
            if (maxCreatedDate == null){
                return null;
            }
            return builder.lessThanOrEqualTo(root.get("createdDate").as(LocalDate.class),maxCreatedDate);
        };
    }
    private static Specification<Product> hasYearEqual(Integer year){
        return (root, query, builder) -> {
            if (year == null){
                return null;
            }
            return builder.equal(
                    builder.function("YEAR",Integer.class,root.get("createdDate")),year
            );
        };
    }

    private static Specification<Product> hasPriceLessThanEqualTo(Double price){
        return (root, query, builder) -> {
            if (price == null) {
                return null;
            }
            return builder.lessThanOrEqualTo(root.get("price"),price);
        };
    }

    public static Specification<Product> hasRamLessThanEqualTo(Product.Ram ram){
        return (root, query, builder) ->{
            if (ram == null){
                return  null;
            }
            return builder.lessThanOrEqualTo(root.get("ram"),ram);
        };
    }
}
