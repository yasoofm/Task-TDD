package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;

import java.util.List;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);
    void updateUserStatus(UpdateUserRequest updateUserRequest);
    List<UserEntity> searchUsers(String status);
}
