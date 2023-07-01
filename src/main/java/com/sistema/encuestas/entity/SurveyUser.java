package com.sistema.encuestas.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "app_users")
public class SurveyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

