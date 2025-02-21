package com.vnpt.store_it.service;

import com.vnpt.store_it.dtos.request.CheckUserLoginRequest;
import com.vnpt.store_it.dtos.request.CreateUserRequest;
import com.vnpt.store_it.dtos.response.CheckUserLoginResponse;
import com.vnpt.store_it.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
    User create(CreateUserRequest request);

    CheckUserLoginResponse checkLogin(CheckUserLoginRequest request);
}
