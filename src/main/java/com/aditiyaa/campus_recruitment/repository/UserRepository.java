package com.aditiyaa.campus_recruitment.repository;

import com.aditiyaa.campus_recruitment.model.Student; // Or User if you created a User class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Student, Long> {
}