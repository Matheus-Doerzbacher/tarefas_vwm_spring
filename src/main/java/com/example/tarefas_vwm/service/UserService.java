package com.example.tarefas_vwm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.tarefas_vwm.model.User;
import com.example.tarefas_vwm.repository.UserRepository;
import com.example.tarefas_vwm.exception.EmailJaCadastradoException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User create(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new EmailJaCadastradoException("Já existe um usuário cadastrado com este email");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User usuarioExistente = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        usuarioExistente.setName(user.getName());
        usuarioExistente.setEmail(user.getEmail());
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            usuarioExistente.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(usuarioExistente);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> authenticate(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }
}
