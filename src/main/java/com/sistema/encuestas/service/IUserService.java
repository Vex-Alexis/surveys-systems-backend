package com.sistema.encuestas.service;

import com.sistema.encuestas.entity.SurveyUser;

public interface IUserService {

    Boolean newUserIsValid(SurveyUser surveyUserDTO);
}
