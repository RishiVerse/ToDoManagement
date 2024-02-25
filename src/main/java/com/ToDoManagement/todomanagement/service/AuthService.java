package com.ToDoManagement.todomanagement.service;

import com.ToDoManagement.todomanagement.dto.LoginDto;
import com.ToDoManagement.todomanagement.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);

}
