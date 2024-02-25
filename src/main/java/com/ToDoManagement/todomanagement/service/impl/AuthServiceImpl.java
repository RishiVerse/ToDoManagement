package com.ToDoManagement.todomanagement.service.impl;

import com.ToDoManagement.todomanagement.dto.LoginDto;
import com.ToDoManagement.todomanagement.dto.RegisterDto;
import com.ToDoManagement.todomanagement.entity.Role;
import com.ToDoManagement.todomanagement.entity.User;
import com.ToDoManagement.todomanagement.repository.RoleRepository;
import com.ToDoManagement.todomanagement.repository.UserRepository;
import com.ToDoManagement.todomanagement.service.AuthService;
import lombok.AllArgsConstructor;
import org.apache.catalina.Authenticator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {


    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    @Override
    public String register(RegisterDto registerDto) {
        User user = new User();

        user.setEmail(registerDto.getEmail());
        user.setName(registerDto.getName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setUsername(registerDto.getUsername());

        Set<Role> role=new HashSet<>();
        Role  userRole=roleRepository.findByName("name");
        role.add(userRole);
        user.setRoles(role);

        userRepository.save(user);



        return "User Registered Successfully!.";
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication response = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginDto.getEmailOrUsername(),loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(response);
        return "login success";
    }
}
