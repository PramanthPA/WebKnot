package com.webknot.service;

import com.webknot.dto.UserDTO;
import com.webknot.entity.User;

public interface UserService {
    User signUp(UserDTO userDTO);
    String signIn(UserDTO userDTO);
}
