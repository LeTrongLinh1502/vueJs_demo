package com.vnpt.store_it.service;

import com.vnpt.store_it.dtos.request.CheckUserLoginRequest;
import com.vnpt.store_it.dtos.request.CreateUserRequest;
import com.vnpt.store_it.dtos.response.CheckUserLoginResponse;
import com.vnpt.store_it.model.User;
import com.vnpt.store_it.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(CreateUserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getUserName());
        return userRepository.save(user);
    }

    @Override
    public CheckUserLoginResponse checkLogin(CheckUserLoginRequest request) {
        User user = userRepository.findFirstByUserNameAndPassword(request.getUserName(), request.getPassword());
        if (Objects.nonNull(user)) {
            return CheckUserLoginResponse.builder()
                    .status(Boolean.TRUE)
                    .build();
        }
        return CheckUserLoginResponse.builder()
                .status(Boolean.FALSE)
                .build();
    }
}
