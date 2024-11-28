package com.example.spring_boot_ensf480_api_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot_ensf480_api_server.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmailAndPassword(String email, String password);
}
