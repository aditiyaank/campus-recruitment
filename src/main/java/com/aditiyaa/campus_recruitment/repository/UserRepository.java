package com.aditiyaa.campus_recruitment.repository;

import com.aditiyaa.campus_recruitment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // This allows us to check if an email is already in the database
    Optional<User> findByEmail(String email);
}