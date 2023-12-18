package com.example.demo.model.pgsql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orders {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public float price;
}
