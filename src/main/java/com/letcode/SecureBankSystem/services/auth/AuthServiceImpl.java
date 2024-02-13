package com.letcode.SecureBankSystem.services.auth;

import com.letcode.SecureBankSystem.bo.auth.AuthenticationResponse;
import com.letcode.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.letcode.SecureBankSystem.bo.auth.CreateSignupRequest;
import com.letcode.SecureBankSystem.bo.auth.LogoutResponse;
import com.letcode.SecureBankSystem.bo.customUserDetails.CustomUserDetails;
import com.letcode.SecureBankSystem.configs.JWTUtil;
import com.letcode.SecureBankSystem.entities.RolesEntity;
import com.letcode.SecureBankSystem.entities.UserEntity;
import com.letcode.SecureBankSystem.repositories.RolesRepository;
import com.letcode.SecureBankSystem.repositories.UserRepository;
import com.letcode.SecureBankSystem.utils.enums.Roles;
import com.letcode.SecureBankSystem.utils.enums.Status;
import com.letcode.SecureBankSystem.utils.exceptions.BodyGuardException;
import com.letcode.SecureBankSystem.utils.exceptions.UserNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService{
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;
    private final RolesRepository rolesRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JWTUtil jwtUtil, RolesRepository rolesRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.rolesRepository = rolesRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void signup(CreateSignupRequest createSignupRequest) {
        /*RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setTitle(Roles.USER);
        rolesRepository.save(rolesEntity);*/
        RolesEntity roleEntity= rolesRepository.findRoleEntityByTitle(Roles.user.name())
                .orElseThrow(() -> new BodyGuardException("no Roles Found"));
        UserEntity user = new UserEntity();
        user.setName(createSignupRequest.getName());
        user.setUsername(createSignupRequest.getUsername());
        user.setPhoneNumber(createSignupRequest.getPhoneNumber());
        user.setEmail(createSignupRequest.getEmail());
        user.setRoles(roleEntity);
        user.setStatus(Status.ACTIVE);
        user.setPassword(bCryptPasswordEncoder.encode(createSignupRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public AuthenticationResponse login(CreateLoginRequest createLoginRequest) {
        requiredNonNull(createLoginRequest.getUsername(), "username");
        requiredNonNull(createLoginRequest.getPassword(), "password");

        String username = createLoginRequest.getUsername().toLowerCase();
        String password = createLoginRequest.getPassword();

        authentication(username, password);

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String accessToken = jwtUtil.generateToken(userDetails);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setRole(userDetails.getRole());
        response.setToken("Bearer " + accessToken);
        return response;
    }

    @Override
    public void logout(LogoutResponse logoutResponse) {
        requiredNonNull(logoutResponse.getToken(), "token");
    }

    @Override
    public List<String> getAllUsersWithStrongPassword() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getPassword().length() > 8)
                .map(UserEntity::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    private void requiredNonNull(Object obj, String name){
        if(obj == null || obj.toString().isEmpty()){
            throw new BodyGuardException(name + " can't be empty");
        }
    }

    private void authentication(String username, String password){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BodyGuardException e){
            throw new BodyGuardException("Incorrect password");
        } catch (AuthenticationServiceException e){
            throw new UserNotFoundException("Incorrect username");
        }
    }
}
