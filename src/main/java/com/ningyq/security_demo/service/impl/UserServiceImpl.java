package com.ningyq.security_demo.service.impl;

import com.ningyq.security_demo.bean.User;
import com.ningyq.security_demo.repository.UserRepository;
import com.ningyq.security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
