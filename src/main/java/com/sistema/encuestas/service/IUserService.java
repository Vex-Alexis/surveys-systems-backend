package com.sistema.encuestas.service;

import com.sistema.encuestas.entity.User;

public interface IUserService {

    Boolean newUserIsValid(User userDTO);
}
