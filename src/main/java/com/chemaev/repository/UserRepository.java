package com.chemaev.repository;

import com.chemaev.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByEmail(String email);

    Page<User> findAll(Pageable pageable);

    @Query("select u from User u where u.email = :email")
    List<User> findAllByEmail(String email);

    Optional<User> findByEmail(String email);

    User findByVerificationCode(String code);
}