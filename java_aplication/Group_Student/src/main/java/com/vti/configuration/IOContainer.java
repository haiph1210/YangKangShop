package com.vti.configuration;

import com.vti.dto.StudentDTO;
import com.vti.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class IOContainer {
    @Bean
    public ModelMapper provideModelMaper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(StudentDTO.class, Student.class)
                .addMappings(mapper->mapper.skip(Student:: setId));
    return modelMapper;
    }
}
