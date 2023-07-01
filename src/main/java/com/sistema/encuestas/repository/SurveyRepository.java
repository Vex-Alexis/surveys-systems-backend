package com.sistema.encuestas.repository;

import com.sistema.encuestas.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("surveyRepo")
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
