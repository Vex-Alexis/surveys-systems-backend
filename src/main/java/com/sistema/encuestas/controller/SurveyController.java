package com.sistema.encuestas.controller;

import com.sistema.encuestas.entity.Survey;
import com.sistema.encuestas.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/neoris/v1/survey-system/survey")
public class SurveyController {

    @Autowired
    private ISurveyService surveyService;

    @PostMapping("/saveSurvey")
    public ResponseEntity<String> saveSurvey(@RequestBody @Valid Survey surveyDTO){
        //TODO: IMPLEMENTAR PATRON DTO Y HERENCIA CON LAS ENTIDADES
        //TODO: IMPLEMENTAR RESPUESTA EXCEPCIONES EN BODY CON @VALID

            if (surveyDTO.getSurveyUser().getEmail() == null) return new ResponseEntity<>( "Falta diligenciar correo", HttpStatus.BAD_REQUEST);
        if (surveyDTO.getSurveyUser().getDni() == null) return new ResponseEntity<>( "Falta diligenciar dni", HttpStatus.BAD_REQUEST);

        var response = surveyService.saveNewSurvey(surveyDTO);

        return new ResponseEntity<>( response ,HttpStatus.ACCEPTED);

    }


}
