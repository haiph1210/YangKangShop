package com.YangKang.repository;

import com.YangKang.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICategoryRepository extends JpaRepository<Category,Integer>, JpaSpecificationExecutor<Category> {
    Category findByName(String name);
    boolean existsByName(String name);
}
