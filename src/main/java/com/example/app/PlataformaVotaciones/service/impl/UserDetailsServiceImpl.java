package com.example.app.PlataformaVotaciones.service.impl;

import com.example.app.PlataformaVotaciones.entities.SecurityUser;
import com.example.app.PlataformaVotaciones.entities.User;
import com.example.app.PlataformaVotaciones.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String emailUser) throws UsernameNotFoundException {
        User user = userRepository.findByEmailUser(emailUser);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new SecurityUser(user);
    }
}
