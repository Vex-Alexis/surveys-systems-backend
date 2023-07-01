package com.sistema.encuestas.repository;

import com.sistema.encuestas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepo")
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByDni(Long dni);
    List<User> findByEmail(String Email);

}
