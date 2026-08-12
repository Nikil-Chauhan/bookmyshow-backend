package com.cfs.bms.service;

import com.cfs.bms.dto.LoginRequest;
import com.cfs.bms.dto.UserRequest;
import com.cfs.bms.entity.User;
import com.cfs.bms.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    //register

    public User register(UserRequest request)
    {
        if(userRepo.existsByEmail(request.getEmail()))
        {
            throw new RuntimeException("Email already exists: "+request.getEmail());
        }

        User user=User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .build();
        return userRepo.save(user);

    }

    //login

    public User login(LoginRequest request)
    {
        User user=userRepo.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("User not found with email: "+request.getEmail()));
        if(!user.getPassword().equals(request.getPassword()))
        {
            throw new RuntimeException("Invalid password");
        }
        return user;
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUserById(Long id)
    {
        return userRepo.findById(id)
                .orElseThrow(()->new RuntimeException("User not found with email: "+id));
    }

}