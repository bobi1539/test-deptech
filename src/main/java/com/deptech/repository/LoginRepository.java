package com.deptech.repository;

import com.deptech.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByEmail(String email);
}
