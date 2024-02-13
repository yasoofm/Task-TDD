package com.letcode.SecureBankSystem.controllers.userController;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcode.SecureBankSystem.entities.UserEntity;
import com.letcode.SecureBankSystem.services.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest){
        try{
            userService.saveUser(createUserRequest);
            return ResponseEntity.ok("User created successfully");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<String> updateStatus(@RequestParam long userId, @RequestParam String status) {
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setUserId(userId);
        updateUserRequest.setStatus(status);
        try {
            userService.updateUserStatus(updateUserRequest);
            return ResponseEntity.ok().body("status updated");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body("User " + userId + " does not exist");
        }
    }

    @GetMapping("/searchUsers")
    public ResponseEntity<?> searchUsers(@RequestParam String status){
        List<UserEntity> users = userService.searchUsers(status);
        return ResponseEntity.ok(users);
    }
}
