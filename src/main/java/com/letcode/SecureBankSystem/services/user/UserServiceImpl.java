package com.letcode.SecureBankSystem.services.user;

import com.letcode.SecureBankSystem.bo.user.CreateUserRequest;
import com.letcode.SecureBankSystem.bo.user.UpdateUserRequest;
import com.letcode.SecureBankSystem.entities.UserEntity;
import com.letcode.SecureBankSystem.utils.enums.Status;
import com.letcode.SecureBankSystem.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
        if (!updateUserRequest.getStatus().toUpperCase().equals(Status.ACTIVE.toString()) && !updateUserRequest.getStatus().toUpperCase().equals(Status.INACTIVE.toString()))
            throw new IllegalArgumentException("Invalid input status should be ACTIVE or INACTIVE");
        UserEntity userEntity = userRepository.findById(updateUserRequest.getUserId()).orElseThrow();
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus().toUpperCase()));
        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> searchUsers(String status) {
        return userRepository.searchUsers(Status.valueOf(status.toUpperCase()));
    }

    @Override
    public List<String> getAllUsersWithStrongPassword() {
        return userRepository.findAll()
                .stream()
                .filter(e -> e.getPassword().length() > 8)
                .map(UserEntity::getName)
                .collect(Collectors.toList());
    }


}
