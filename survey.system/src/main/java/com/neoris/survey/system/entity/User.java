package com.sistema.encuestas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "dni",  unique = true)
    private Long dni;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "surname", nullable = false)
    private String surname;

    @Column(name= "email", nullable = false, unique = true)
    private String email;

    @Column(name= "password", nullable = false)
    private String password;

    @Column(name = "attempts", nullable = false)
    private int attempts;

    @Column(name = "lock", nullable = false)
    private boolean lock;
}

