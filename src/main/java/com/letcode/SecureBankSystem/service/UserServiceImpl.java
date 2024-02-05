package com.letcode.SecureBankSystem.service;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcode.SecureBankSystem.entity.UserEntity;
import com.letcode.SecureBankSystem.models.Status;
import com.letcode.SecureBankSystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus().toUpperCase()));
        userRepository.save(userEntity);
    }

    @Override
    public void updateUserStatus(UpdateUserRequest updateUserRequest){
        UserEntity userEntity = userRepository.getById(updateUserRequest.getUserId());
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus().toUpperCase()));
        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> searchUsers(String status) {
        return userRepository.searchUsers(Status.valueOf(status.toUpperCase()));
    }


}
