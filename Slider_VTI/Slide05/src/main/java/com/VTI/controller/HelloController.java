package com.VTI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("")
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name",defaultValue = "Spring") String name){
        return "Hello," + name;
    }

}
