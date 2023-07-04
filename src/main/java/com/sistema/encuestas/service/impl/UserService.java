package com.sistema.encuestas.service.impl;

import com.sistema.encuestas.entity.SurveyUser;
import com.sistema.encuestas.repository.UserRepository;
import com.sistema.encuestas.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public Boolean newUserIsValid(SurveyUser surveyUserDTO) {
        var usersByEmailList = userRepo.findByEmail(surveyUserDTO.getEmail()) == null ? null : userRepo.findByEmail(surveyUserDTO.getEmail());
        var usersByDniList = userRepo.findByDni(surveyUserDTO.getDni())  == null ? null : userRepo.findByDni(surveyUserDTO.getDni());

        return usersByDniList == null && usersByEmailList == null;
    }
}
