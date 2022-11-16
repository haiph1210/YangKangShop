package com.vti.slide08.specification;

import com.vti.slide08.entity.Department;
import com.vti.slide08.form.DepartmentFilterForm;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class DepartmentSpecification {
    public static Specification<Department> buildWhere(DepartmentFilterForm form){
        if (form == null){
            return null;
        }
        return hasCreatedDateEqual(form.getCreatedDate()).and(hasCreatedDateGreaterThanOrEqualTo(form.getMinCreatedDate()).and(hasTypeEqual(form.getType()))
                .and(hasCreatedDateLessThanOrEqualTo(form.getMaxCreatedDate()).and(hasCreatedYearGreaterThanOrEqualTo(form.getMinCreatedYear()))));
//    if (form == null) {
//            return null;
//        }
//        return hasCreatedDateEqual(form.getCreatedDate())
//                .and(hasCreatedDateGreaterThanOrEqualTo(form.getMinCreatedDate()))
//                .and(hasCreatedDateLessThanOrEqualTo(form.getMaxCreatedDate()))
//                .and(hasCreatedYearGreaterThanOrEqualTo(form.getMinCreatedYear()));

    }
    public static Specification<Department> hasCreatedDateEqual(LocalDate createDate){
        return new Specification<Department>() {
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (createDate == null){
                    return null;
                }
                return builder.equal(root.get("createdDate").as(LocalDate.class),createDate);
            }
        };
    }
//    private static Specification<Department> hasCreatedDateGreaterThanOrEqualTo(LocalDate minCreatedDate) {
//        return new Specification<Department>() {
//            @Override
//            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//                if (minCreatedDate == null){
//                    return null;
//                }
//                return builder.greaterThanOrEqualTo(root.get("minCreatedDate").as(LocalDate.class),minCreatedDate);
//            }
//        }
//    }
//
//    private static Specification<Department> hasCreatedDateLessThanOrEqualTo(LocalDate maxCreatedDate) {
//        return new Specification<Department>() {
//            @Override
//            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//                if (maxCreatedDate == null){
//                    return null;
//                }
//                return builder.equal(root.get("maxCreatedDate").as(LocalDate.class),maxCreatedDate);
//            }
//        }
//    }

    private static Specification<Department> hasCreatedDateGreaterThanOrEqualTo(LocalDate minCreatedDate) {
        return (root, query, builder) -> {
            if (minCreatedDate == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get("createdDate").as(LocalDate.class), minCreatedDate);
        };
    }

    private static Specification<Department> hasCreatedDateLessThanOrEqualTo(LocalDate maxCreatedDate) {
        return (root, query, builder) -> {
            if (maxCreatedDate == null) {
                return null;
            }
            return builder.lessThanOrEqualTo(root.get("createdDate").as(LocalDate.class), maxCreatedDate);
        };
    }


    private static Specification<Department> hasCreatedYearGreaterThanOrEqualTo(Integer minCreatedYear) {
        return (root, query, builder) -> {
            if (minCreatedYear == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(
                    builder.function("YEAR", Integer.class, root.get("createdDate")),
                    minCreatedYear
            );
        };
    }

    public static Specification<Department> hasTypeEqual(Department.Type type){
        return new Specification<Department>() {
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                if (type == null){
                    return null;
                }
                return builder.equal(root.get("type"),type);
            }
        };
    }

}
