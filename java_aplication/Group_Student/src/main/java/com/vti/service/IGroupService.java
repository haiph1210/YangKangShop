package com.vti.service;

import com.vti.entity.Group;
import com.vti.form.GroupCreateForm;
import com.vti.form.GroupUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGroupService {
    Page<Group> findAll(Pageable pageable);

    Group findById(Integer id);

    Group findByName(String name);

    void create(GroupCreateForm form);

    void update(GroupUpdateForm form);

    void deleteById(Integer id);
}
