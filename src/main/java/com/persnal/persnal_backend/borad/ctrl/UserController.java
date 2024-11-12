package com.persnal.persnal_backend.borad.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persnal.persnal_backend.borad.domain.user.UserRequestDTO;
import com.persnal.persnal_backend.borad.domain.user.UserResponseDTO;
import com.persnal.persnal_backend.borad.service.UserService;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("join")
    public ResponseEntity<String> signUp(@RequestBody UserRequestDTO userRequestDTO) {
        userService.registerUser(userRequestDTO);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO loginRequest, HttpSession session) {
        UserResponseDTO user = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        session.setAttribute("user", user);
        System.out.println("Login success");
        return ResponseEntity.ok(user);
    }
}
