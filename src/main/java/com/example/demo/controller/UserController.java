package com.example.demo.controller;

import com.example.demo.model.pgsql.Orders;
import com.example.demo.model.mysql.User;
import com.example.demo.repository.pgsql.OrderRepository;
import com.example.demo.repository.mysql.UserRepository;
import com.example.demo.service.DemoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DemoService demoService;


    @GetMapping
    public String createUser(){
        User user = new User();
        user.setName("Swarup");
        repository.save(user);
        return "User Created Successfully.";
    }

    @GetMapping("/order")
    public String createOrder(){
        Orders order = new Orders();
        order.setName("IPHONE");
        order.setPrice(100f);
        orderRepository.save(order);
        return "order created successfully";
    }

    @GetMapping("/getAll")
    public List<User> getAllUser(){

        return repository.findAll();
    }
    @GetMapping("/getOrder")
    public List<Orders> getOrders(){

        return orderRepository.findAll();
    }

    @GetMapping("/save")
    public String save() throws Exception {
        String s = demoService.saveDetails();
        return s;
    }

}
