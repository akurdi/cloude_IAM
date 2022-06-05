package com.psut.psutiam.db.repo;

import com.psut.psutiam.db.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public interface LoginRepo extends JpaRepository<Login, Long> {
    Optional<Login> findLoginByUsername(String username);

    Optional<Login> findLoginByUsernameAndPassword(String username, String password);
}
