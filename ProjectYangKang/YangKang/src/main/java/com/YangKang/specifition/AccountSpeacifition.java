package com.YangKang.specifition;

import com.YangKang.entity.Account;
import com.YangKang.form.AccountFillterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class AccountSpeacifition {
    public static Specification<Account> buildWhere(AccountFillterForm form){
        if (form == null){
            return null;
        }
            return hasUsernameLike(form.getSearch()).or(hasFullnameLike(form.getSearch()))
                    .and(hasRoleEqual(form.getRole())
                            .and(hasCreatedDateEqual(form.getCreatedDate())
                                    .and(hasMinCreatedDateGenterThanEqualTo(form.getMinCreatedDate())
                                            .and(hasMaxCreatedDateLessThanOrEqualTo(form.getMaxCreatedDate())
                                                    .and(hasYearEqual(form.getYear()))))))
                    ;
    }
    private static Specification<Account> hasUsernameLike(String search){
        return (root, query, builder) -> {
            if (!StringUtils.hasText(search)){
            return null;
        }
            return builder.like(root.get("username"), "%"+ search +"%" );
        };
    }
    private static Specification<Account> hasFullnameLike(String search){
        return (root, query, builder) -> {
            if (!StringUtils.hasText(search)){
                return null;
            }return builder.like(root.get("fullName"),"%"+ search +"%");
        };
    }
    private static Specification<Account> hasRoleEqual(Account.Role role){
        return (root, query, builder) -> {
            if (role == null){
                return null;
            }
            return builder.equal(root.get("role"),role);
        };
    }
    private static Specification<Account> hasCreatedDateEqual(LocalDate createdDate){
        return (root, query, builder) -> {
            if (createdDate == null){
                return null;
            }
            return builder.equal(root.get("createdDate").as(LocalDate.class),createdDate);
        };
    }
    private static Specification<Account> hasMinCreatedDateGenterThanEqualTo(LocalDate minCreatedDate){
        return (root, query, builder) -> {
            if (minCreatedDate == null){
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get("createdDate").as(LocalDate.class),minCreatedDate);
        };
    }
    private static Specification<Account> hasMaxCreatedDateLessThanOrEqualTo(LocalDate maxCreatedDate){
        return (root, query, builder) -> {
            if (maxCreatedDate == null){
                return null;
            }
            return builder.lessThanOrEqualTo(root.get("createdDate").as(LocalDate.class),maxCreatedDate);
        };
    }
    private static Specification<Account> hasYearEqual(Integer year){
        return (root, query, builder) -> {
            if (year == null){
                return null;
            }
            return builder.equal(
                    builder.function("YEAR",Integer.class,root.get("createdDate")),year
            );
        };
    }
}
