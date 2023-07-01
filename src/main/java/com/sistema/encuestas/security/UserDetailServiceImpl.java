package com.sistema.encuestas.security;

import com.sistema.encuestas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var loggedUser = userRepository.findOneByEmail(email).orElseThrow( () -> new UsernameNotFoundException("Las credenciales son incorrectas"));
        return new UserDetailsImpl(loggedUser);
    }
}
