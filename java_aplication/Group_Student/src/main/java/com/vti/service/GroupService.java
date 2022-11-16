package com.vti.service;

import com.vti.entity.Group;
import com.vti.entity.Student;
import com.vti.form.GroupCreateForm;
import com.vti.form.GroupUpdateForm;
import com.vti.repository.IGroupRepository;
import com.vti.repository.IStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private IGroupRepository repository;
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Group> findAll(Pageable pageable){
      return   repository.findAll(pageable);
    }

    @Override
    public Group findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Group findByName(String name){
        return repository.findByName(name);
    }
    @Override
    @Transactional
    public void create(GroupCreateForm form){
        Group group = mapper.map(form,Group.class);
        Group saved = repository.save(group);
        List<Student>students =group.getStudents();
        for (Student student : students) {
            student.setGroups((List<Group>) saved);
        }
        studentRepository.saveAll(students);
    }

    @Override
    public void update(GroupUpdateForm form){
        Group group = mapper.map(form,Group.class);
    }

    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
