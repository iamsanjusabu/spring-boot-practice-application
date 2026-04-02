package com.sanjusabu.springboot.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users_table")
public class User {

    @Id
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(15)")
    private String name;

    @Column(name = "age", columnDefinition = "INT")
    private Integer age;

    @Column(name = "gender", columnDefinition = "CHAR(1)")
    private Character gender;

    @Column(name = "email", columnDefinition = "VARCHAR(50)")
    private String email;
}
