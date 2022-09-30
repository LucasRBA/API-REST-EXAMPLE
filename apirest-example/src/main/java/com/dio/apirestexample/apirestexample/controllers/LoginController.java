package com.dio.apirestexample.apirestexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dio.apirestexample.apirestexample.repositories.UserRepository;
import com.dio.apirestexample.apirestexample.security.SecurityConfig;
import com.dio.apirestexample.apirestexample.security.JWTObject;
import com.dio.apirestexample.apirestexample.security.JWTCreator;
import com.dio.apirestexample.apirestexample.models.User;
import com.dio.apirestexample.apirestexample.dtos.Session;
import com.dio.apirestexample.apirestexample.dtos.Login;
import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Session  log(@RequestBody Login login){
        User user = repository.findByUsername(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Invalid password for user: " + login.getUsername());
            }
             Session session = new Session ();
            session.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            session.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return session;
        }else {
            throw new RuntimeException("There was an error trying to log you in... Try again later.");
        }
    }
}
