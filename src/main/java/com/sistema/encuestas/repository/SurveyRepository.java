package com.sistema.encuestas.repository;

import com.sistema.encuestas.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
