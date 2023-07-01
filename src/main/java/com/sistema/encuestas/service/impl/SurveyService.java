package com.sistema.encuestas.service.impl;

import com.sistema.encuestas.entity.Survey;
import com.sistema.encuestas.repository.SurveyRepository;
import com.sistema.encuestas.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService implements ISurveyService {

    @Autowired
    private  SurveyRepository surveyRepo;



    @Autowired
    private UserService userService;

    @Override
    public String saveNewSurvey(Survey surveyDTO) {

        if (!userService.newUserIsValid(surveyDTO.getUser())){
            //TODO: capturar respuesta de servicio para informar si se quedo por EMAIL o DNI
            return "el usuario ya respondio una encuesta anteriormente";
        }

        var saveSurveyReponse = surveyRepo.save(surveyDTO);
        return String.format("Encuesta guardada correctamente, se envia copia al correo: %s", saveSurveyReponse.getUser().getEmail());
    }

}
