package com.meac.authentication_api.controller;

import com.meac.authentication_api.domain.user.AuthUserDTO;
import com.meac.authentication_api.domain.user.LoginResponseDTO;
import com.meac.authentication_api.domain.user.RegisterUserDTO;
import com.meac.authentication_api.domain.user.User;
import com.meac.authentication_api.infrastructure.security.TokenService;
import com.meac.authentication_api.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthUserDTO authUserDTO ) {

            var usernamePassword = new UsernamePasswordAuthenticationToken(authUserDTO.username(), authUserDTO.password());

            var auth = authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterUserDTO registerUserDTO) {

        if (userRepository.findByLogin(registerUserDTO.username()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerUserDTO.password());
        userRepository.save(new User(registerUserDTO.username(), encryptedPassword, registerUserDTO.role()));

        return ResponseEntity.ok().build();
    }
}
