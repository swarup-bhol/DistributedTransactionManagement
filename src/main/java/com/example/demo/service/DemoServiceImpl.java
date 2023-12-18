package com.example.demo.service;

import com.example.demo.model.mysql.User;
import com.example.demo.model.pgsql.Orders;
import com.example.demo.repository.mysql.UserRepository;
import com.example.demo.repository.pgsql.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl implements  DemoService{

    @Autowired
    UserRepository repository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional(value = "chainedTransactionManager", rollbackFor = {Exception.class}, isolation = Isolation.READ_UNCOMMITTED)
    public String saveDetails() {
        User user = new User();
        user.setName("Jhon Doe");
        repository.save(user);
        Orders order = new Orders();
        order.setName("Oneplus 9rt");
        order.setPrice(10f);
        orderRepository.save(order);

        return "Working fine";
    }

}
