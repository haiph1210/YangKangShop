package com.VTI.controller;

import com.VTI.entity.Department;
import com.VTI.repository.IDepartmentRepository;
import com.VTI.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@CrossOrigin("http://127.0.0.1:5500/")
public class DepartmentController {
    @Autowired // tự động tạo mới
    private IDepartmentService service;


    @GetMapping
    public List<Department> getAll() {
        return service.getAll();
    }

    // .../departments?name = spring => requestParam
    // .../departments/1  => pathvariable
    @GetMapping("/{id}")
    public Department getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping("/name/{name}")
    public Department getByName(@PathVariable String name) {
        return service.getByName(name);
    }

    @PostMapping
    public void create(@RequestBody Department department) {
        service.create(department);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Department department) {
        department.setId(id);
        service.update(department);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }


    public boolean existsById(int id) {
        return service.existsById(id);
    }


    public boolean existsByName(String name) {
        return service.existsByName(name);
    }
}
