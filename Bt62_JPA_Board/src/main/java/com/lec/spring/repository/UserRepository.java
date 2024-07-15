package com.lec.spring.repository;

import com.lec.spring.domain.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("SELECT u.password FROM User u WHERE u.username = :username")
    User findByUsername(String username);
}