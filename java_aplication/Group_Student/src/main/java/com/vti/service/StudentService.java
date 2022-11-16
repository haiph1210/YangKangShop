package com.vti.service;

import com.vti.entity.Group;
import com.vti.entity.Student;
import com.vti.form.StudentCreateForm;
import com.vti.form.StudentUpdateForm;
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
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository repository;
    @Autowired
    private IGroupRepository groupRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Student> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    @Override
    public Student findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student findByEmail(String email){
        return repository.findByEmail(email);
    }

    @Override
    @Transactional
    public void create(StudentCreateForm form){
        Student student = mapper.map(form,Student.class);
        Student saved = repository.save(student);
        List<Group> groups = student.getGroups();
        for (Group group : groups) {
//            group.setStudents();
        }
        groupRepository.saveAll(groups);
    }
    @Override
    public void update(StudentUpdateForm form){
        Student student = mapper.map(form,Student.class);
        repository.save(student);
    }
    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
