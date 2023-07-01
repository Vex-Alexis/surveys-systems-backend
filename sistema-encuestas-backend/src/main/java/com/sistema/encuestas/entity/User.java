package com.sistema.encuestas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name= "dni")
    private Long dni;

    @Column(name= "name")
    private String name;

    @Column(name= "surname")
    private String surname;

    @Column(name= "email")
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name = "attempts")
    private int attempts;

    @Column(name = "lock")
    private boolean lock;
}

