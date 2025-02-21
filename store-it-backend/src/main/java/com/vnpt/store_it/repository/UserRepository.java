package com.vnpt.store_it.repository;

import com.vnpt.store_it.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByUserNameAndPassword(String username, String password);
}
