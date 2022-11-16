package com.vti.slide08.controller;

import com.vti.slide08.dto.DepartmentDTO;
import com.vti.slide08.entity.Account;
import com.vti.slide08.entity.Department;
import com.vti.slide08.form.DepartmentCreateForm;
import com.vti.slide08.form.DepartmentFilterForm;
import com.vti.slide08.form.DepartmentUpdateForm;
import com.vti.slide08.repository.IAccountRepository;
import com.vti.slide08.service.IDepartmentService;
import com.vti.slide08.validation.DepartmentIdExists;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import javax.persistence.spi.LoadState;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public Page<DepartmentDTO> findAll(Pageable pageable, DepartmentFilterForm form){
       Page <Department> page = service.findAll(pageable,form);
        List<Department> departments = page.getContent();
        List<DepartmentDTO> dtos = mapper.map(departments,new TypeToken<List<DepartmentDTO>>(){}.getType());
        for (DepartmentDTO dto : dtos) {
            dto.add(
                    linkTo(
                            methodOn(DepartmentController.class).findById(dto.getId())
                    ).withSelfRel()
            );
            for (DepartmentDTO.AccountDTO account : dto.getAccounts()) {
                account.add(linkTo(methodOn(AccountController.class).findById(account.getId())).withSelfRel());
            }

        }
        return new PageImpl<>(dtos,pageable,page.getTotalPages());
    }
    @GetMapping("/{id}")
    public DepartmentDTO findById(@PathVariable Integer id){
        Department department = service.findById(id);
        DepartmentDTO dto = mapper.map(department,DepartmentDTO.class);
        dto.add(
                linkTo(
                        methodOn(DepartmentController.class).findById(id)
                ).withSelfRel()
        );

        return dto;
    }
    @GetMapping("/name/{name}")
    public Department findByName(@PathVariable String name){
        return service.findByName(name);
    }
    @PostMapping
    public void create(@Valid @RequestBody DepartmentCreateForm form){

        service.create(form);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable @DepartmentIdExists Integer id, @RequestBody DepartmentUpdateForm form){
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
