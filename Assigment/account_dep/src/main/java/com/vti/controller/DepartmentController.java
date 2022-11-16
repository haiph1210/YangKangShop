package com.vti.controller;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public Page<DepartmentDTO> findAll(Pageable pageable){
        Page<Department> page = service.findAll(pageable);
        List<Department> departments = page.getContent();
        List<DepartmentDTO>dtos =mapper.map(departments,new TypeToken< List<DepartmentDTO>>(){}.getType());
        return new PageImpl<>(dtos,pageable,page.getTotalPages());
    }
    @GetMapping("/{id}")
    public DepartmentDTO findById(@PathVariable Integer id){
        Department department = service.findById(id);
        return mapper.map(department,DepartmentDTO.class);
    }
    @PostMapping
    public void create(@RequestBody DepartmentCreateForm form){
        service.create(form);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody DepartmentUpdateForm form){
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
