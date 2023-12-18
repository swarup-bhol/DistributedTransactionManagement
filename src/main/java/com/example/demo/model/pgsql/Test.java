package com.example.demo.model.pgsql;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Test {

    @Id
    private long id;
    private  String name;
}
