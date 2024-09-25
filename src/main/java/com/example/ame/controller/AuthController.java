package com.example.ame.controller;

import com.example.ame.domain.User;
import com.example.ame.model.dto.LoginRequestDTO;
import com.example.ame.model.dto.ResponseDTO;
import com.example.ame.repository.UserRepository;
import com.example.ame.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        User user = this.userRepository.findByLogin(body.login()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getLogin(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody LoginRequestDTO body) {
        Optional<User> user = this.userRepository.findByLogin(body.login());
        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setLogin(body.login());
            newUser.setPassword(passwordEncoder.encode(body.password()));
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getLogin(), token));

        }
        return ResponseEntity.badRequest().build();
    }
}
