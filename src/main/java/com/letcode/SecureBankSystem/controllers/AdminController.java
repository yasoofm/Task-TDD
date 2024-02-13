package com.letcode.SecureBankSystem.controllers;

import com.letcode.SecureBankSystem.entities.UserEntity;
import com.letcode.SecureBankSystem.repositories.UserRepository;
import com.letcode.SecureBankSystem.services.auth.AuthService;
import com.letcode.SecureBankSystem.services.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final UserRepository userRepository;
    private final AuthService authService;

    public AdminController(UserRepository userRepository, UserService userService, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers(){
        List<UserEntity> users = authService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("strong-password-users")
    public ResponseEntity<List<String>> getUsersWithStrongPasswords(){
        List<String> users = authService.getAllUsersWithStrongPassword();
        return ResponseEntity.ok().body(users);
    }
}
