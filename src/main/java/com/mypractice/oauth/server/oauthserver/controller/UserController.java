package com.mypractice.oauth.server.oauthserver.controller;

import com.mypractice.oauth.server.oauthserver.dto.UserDto;
import com.mypractice.oauth.server.oauthserver.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public record UserController(UserService userService) {

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody final UserDto userDto) {
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/employee-id")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") final Integer employeeId) {
        return new ResponseEntity<>(userService.findUserById(employeeId), HttpStatus.OK);
    }

    @GetMapping("/{name}/user-name")
    public ResponseEntity<UserDto> findUserByUserName(@PathVariable("name") final String userName) {
        return new ResponseEntity<>(userService.findUserByUserName(userName), HttpStatus.OK);
    }

    @GetMapping("/{email}/user-email")
    public ResponseEntity<UserDto> findUserByEmail(@PathVariable("email") final String email) {
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }
    @PostMapping("/role")
    public ResponseEntity<UserDto> addRole(@RequestBody final UserDto userDto) {
        return new ResponseEntity<>(userService.addRole(userDto), HttpStatus.CREATED);
    }
}
