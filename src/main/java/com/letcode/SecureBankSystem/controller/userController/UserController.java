package com.letcode.SecureBankSystem.controller.userController;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.models.Status;
import com.letcode.SecureBankSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest){
        userService.saveUser(createUserRequest);
        return ResponseEntity.ok("User created successfully");
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<String> updateStatus(@RequestParam long userId, @RequestParam String status) {
        if (!status.toUpperCase().equals(Status.ACTIVE.toString()) && !status.toUpperCase().equals(Status.INACTIVE.toString()))
            return ResponseEntity.badRequest().body("Invalid input for parameter status");
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setUserId(userId);
        updateUserRequest.setStatus(status);
        userService.updateUserStatus(updateUserRequest);
        return ResponseEntity.ok().body("status updated");
    }

    @GetMapping("/searchUsers")
    public ResponseEntity<?> searchUsers(@RequestParam String status){
        List<UserEntity> users = userService.searchUsers(status);
        return ResponseEntity.ok(users);
    }
}
