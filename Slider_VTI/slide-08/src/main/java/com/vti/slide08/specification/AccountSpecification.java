package com.vti.slide08.specification;

import com.vti.slide08.entity.Account;
import com.vti.slide08.form.AccountFIlterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AccountSpecification  {
    public static Specification<Account> buildWhere(AccountFIlterForm form){
        if (form == null){
            return null;
        }
        return hasUsernameLike(form.getSearch()).or(hasDepartmentNameLike(form.getSearch()
                ).and(hasIdGreaterThanOrEqual(form.getMinId()).and(hasIdLessThanOrEqual(form.getMaxId()))));
    }
    private static Specification<Account> hasUsernameLike(String search){
        return new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (!StringUtils.hasText(search)){
                    return null;
                }
                return builder.like(root.get("username"),"%"+ search.trim() + "%");
            }
        };
    }
//so sánh filter
    private static Specification<Account> hasDepartmentNameLike(String search){
        return new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (!StringUtils.hasText(search)){
                    return null;
                }
                return builder.like(root.get("department").get("name"),"%"+ search.trim() + "%");
            }
        };
    }
    private static Specification<Account> hasIdGreaterThanOrEqual(Integer minId){
        return new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if(minId == null){
                    return null;
                }
                return builder.greaterThanOrEqualTo(root.get("id"),minId);
            }
        };
    }

    private static Specification<Account> hasIdLessThanOrEqual(Integer maxId){
        return new Specification<Account>() {
            @Override
            public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if(maxId == null){
                    return null;
                }
                return builder.lessThanOrEqualTo(root.get("id"),maxId);
            }
        };
    }


}
