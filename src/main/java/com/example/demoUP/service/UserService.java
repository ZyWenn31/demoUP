package com.example.demoUP.service;

import com.example.demoUP.model.User;
import com.example.demoUP.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(Long id, User updatedUser) {
        return repository.findById(id).map(u -> {
            u.setFullName(updatedUser.getFullName());
            u.setLogin(updatedUser.getLogin());
            u.setPasswordPlain(updatedUser.getPasswordPlain());
            //u.setRole(updatedUser.getRole());
            return repository.save(u);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean userSearched(String login, String password){
        if (repository.findByLogin(login) == null){
            return false;
        }
        if (repository.findByLogin(login).getPasswordPlain().equals(password)){
            return true;
        }

        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User getByLogin(String login) {
        return repository.findByLogin(login);
    }
}

