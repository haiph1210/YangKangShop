package com.vti.controller;

import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.form.GroupCreateForm;
import com.vti.form.GroupUpdateForm;
import com.vti.form.StudentCreateForm;
import com.vti.form.StudentUpdateForm;
import com.vti.service.IGroupService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    @Autowired
    private IGroupService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public Page<GroupDTO> findAll(Pageable pageable){
        Page<Group> page = service.findAll(pageable);
        List<Group> groups = page.getContent();
        List<GroupDTO> dtos = mapper.map(groups,new TypeToken<List<GroupDTO>>(){}.getType());
        return new PageImpl<>(dtos,pageable,page.getTotalPages());
    }
    @GetMapping("/{id}")
    public GroupDTO findById(Integer id){
        Group group = service.findById(id);
        return mapper.map(group,GroupDTO.class);
    }
    @GetMapping("/name/{name}")
    public GroupDTO findByName(String name){
        Group group = service.findByName(name);
        return mapper.map(group,GroupDTO.class);
    }
    @PostMapping
    public void create(@RequestBody GroupCreateForm form){

        service.create(form);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody GroupUpdateForm form){
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
