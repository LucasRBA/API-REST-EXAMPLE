package com.dio.apirestexample.apirestexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dio.apirestexample.apirestexample.repositories.UserRepository;
import com.dio.apirestexample.apirestexample.models.User;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    public void createUser(User user){
        String pass = user.getPassword();
        //salting password
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }
}
