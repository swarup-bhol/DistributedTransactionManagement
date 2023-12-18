package com.example.demo.repository.pgsql;

import com.example.demo.model.pgsql.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRespository extends JpaRepository<Test,Long> {
}
