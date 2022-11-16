package com.vti.controller;

import com.vti.dto.StudentDTO;
import com.vti.entity.Student;
import com.vti.form.StudentCreateForm;
import com.vti.form.StudentUpdateForm;
import com.vti.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private IStudentService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<StudentDTO> findAll(Pageable pageable){
        Page<Student> page = service.findAll(pageable);
        List<Student> students = page.getContent();
        List<StudentDTO> dtos = mapper.map(students,new TypeToken<List<StudentDTO>>(){}.getType());
        return new PageImpl<>(dtos,pageable,page.getTotalPages());
    }
    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Integer id){
        Student student = service.findById(id);
        return mapper.map(student,StudentDTO.class);
    }
    @GetMapping("/email/{email}")
    public StudentDTO findByEmail(@PathVariable String email){
        Student student = service.findByEmail(email);
        return mapper.map(student,StudentDTO.class);
    }
    @PostMapping
    public void create(@RequestBody StudentCreateForm form){

        service.create(form);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody StudentUpdateForm form){
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
