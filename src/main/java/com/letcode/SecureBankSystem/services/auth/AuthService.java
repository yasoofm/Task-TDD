package com.letcode.SecureBankSystem.services.auth;

import com.letcode.SecureBankSystem.bo.auth.AuthenticationResponse;
import com.letcode.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.letcode.SecureBankSystem.bo.auth.CreateSignupRequest;
import com.letcode.SecureBankSystem.bo.auth.LogoutResponse;
import com.letcode.SecureBankSystem.entities.UserEntity;

import java.util.List;

public interface AuthService {
    void signup(CreateSignupRequest createSignupRequest);
    AuthenticationResponse login(CreateLoginRequest createLoginRequest);
    void logout(LogoutResponse logoutResponse);

    List<String> getAllUsersWithStrongPassword();

    List<UserEntity> getAllUsers();

}
