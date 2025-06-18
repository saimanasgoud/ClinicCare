package com.example.demo.UserRepositior;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.User.UserLoginOrSignUp;

public interface UserDao extends JpaRepository<UserLoginOrSignUp, Long> {

    UserLoginOrSignUp findByEmail(String email);


}