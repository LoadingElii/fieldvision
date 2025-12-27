package com.bkendbp.fieldsight.user.repository;

import com.bkendbp.fieldsight.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Boolean existsByEmail(String email);
    public Optional<User> findByUsername(String username);

}
