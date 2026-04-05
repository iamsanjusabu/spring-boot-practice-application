package com.sanjusabu.springbootproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "email")
    private String email;
}
