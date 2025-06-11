package com.example.app.PlataformaVotaciones.repositories;

import com.example.app.PlataformaVotaciones.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailUser(String emailUser);
}
