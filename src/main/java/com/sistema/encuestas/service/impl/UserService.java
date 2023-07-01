package com.sistema.encuestas.service.impl;

import com.sistema.encuestas.entity.User;
import com.sistema.encuestas.repository.UserRepository;
import com.sistema.encuestas.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public Boolean newUserIsValid(User userDTO) {
        var usersByEmailList = userRepo.findByEmail(userDTO.getEmail()) == null ? null : userRepo.findByEmail(userDTO.getEmail());
        var usersByDniList = userRepo.findByDni(userDTO.getDni())  == null ? null : userRepo.findByDni(userDTO.getDni());

        return usersByDniList == null && usersByEmailList == null;
    }
}
