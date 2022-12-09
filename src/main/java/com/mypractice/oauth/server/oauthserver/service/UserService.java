package com.mypractice.oauth.server.oauthserver.service;

import com.mypractice.oauth.server.oauthserver.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    UserDto registerUser(final UserDto userDto);
    UserDto findUserById(Integer employeeId);
    UserDto findUserByUserName(String userName);
    UserDto findUserByEmail(String email);
    UserDto addRole(UserDto userDto);
}
