package com.example.demoUP.repository;

import com.example.demoUP.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // поиск пользователя по логину
    User findByLogin(String login);
}
