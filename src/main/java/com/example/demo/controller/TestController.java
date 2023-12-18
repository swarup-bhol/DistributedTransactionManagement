package com.example.demo.controller;

import com.example.demo.model.pgsql.Test;
import com.example.demo.repository.pgsql.TestRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestRespository testRespository;

    @GetMapping
    public String saveTest(){
        Test t = new Test(12,"Swarup");
        testRespository.save(t);
        return "Test save successfully..";
    }

    @GetMapping("/get")
    public List<Test> getTest(){
        List<Test> all = testRespository.findAll();
        return all;
    }
}
