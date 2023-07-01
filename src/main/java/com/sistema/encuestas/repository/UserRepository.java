package com.sistema.encuestas.repository;

import com.sistema.encuestas.entity.SurveyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepo")
public interface UserRepository extends JpaRepository<SurveyUser, Long> {

    List<SurveyUser> findByDni(Long dni);
    List<SurveyUser> findByEmail(String email);

    Optional<SurveyUser> findOneByEmail(String email);

}
