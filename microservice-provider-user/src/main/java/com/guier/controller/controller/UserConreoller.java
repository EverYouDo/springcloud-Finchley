package com.guier.controller;

import com.guier.dao.User;
import com.guier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserConreoller {
    @Value("${server.port}")
    private int port;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        System.out.println("端口："+port);
        return this.userRepository.findById(id);
    }
}
