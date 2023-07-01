package com.sistema.encuestas.service;

import com.sistema.encuestas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;

}
