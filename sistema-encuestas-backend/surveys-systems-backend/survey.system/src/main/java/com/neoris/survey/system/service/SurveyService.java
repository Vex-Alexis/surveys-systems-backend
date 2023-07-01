package com.sistema.encuestas.service;

import com.sistema.encuestas.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    @Autowired
    private  SurveyRepository encuestaRepository;

}
