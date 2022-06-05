package com.psut.psutiam.db.repo;


import com.psut.psutiam.db.entity.Role;
import com.psut.psutiam.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Optional<User>  findUserByUuid(String uuid);

    Iterable<User> findUsersByRole(Role role);
}