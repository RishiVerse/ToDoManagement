package com.ToDoManagement.todomanagement.controller;


import com.ToDoManagement.todomanagement.dto.LoginDto;
import com.ToDoManagement.todomanagement.dto.RegisterDto;
import com.ToDoManagement.todomanagement.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto)
    {
        String response= authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto)
    {
        String response= authService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
