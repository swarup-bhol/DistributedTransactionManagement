package com.example.demo.repository.pgsql;

import com.example.demo.model.pgsql.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

}
