package com.mypractice.oauth.server.oauthserver.service.impl;

import com.mypractice.oauth.server.oauthserver.dto.UserDto;
import com.mypractice.oauth.server.oauthserver.entity.User;
import com.mypractice.oauth.server.oauthserver.exception.ResourceNotFound;
import com.mypractice.oauth.server.oauthserver.repository.UserRepository;
import com.mypractice.oauth.server.oauthserver.service.RoleService;
import com.mypractice.oauth.server.oauthserver.service.UserService;
import com.mypractice.oauth.server.oauthserver.util.MapperUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public record UserServiceImpl(UserRepository repository, PasswordEncoder bCryptPasswordEncoder,
                              RoleService roleService) implements UserService {
    @Override
    public List<UserDto> findAllUsers() {
        return MapperUtil.mapAll(repository.findAll(), UserDto.class);
    }

    @Override
    public UserDto registerUser(final UserDto userDto) {
        final var users = MapperUtil.map(userDto, User.class);
        users.setPassword("{bcrypt}" + bCryptPasswordEncoder.encode(userDto.getPassword()));
        return MapperUtil.map(repository.save(users), UserDto.class);
    }

    @Override
    public UserDto findUserById(final Integer employeeId) {
        return repository.findById(employeeId)
                .map(entity -> MapperUtil.map(entity, UserDto.class))
                .orElseThrow(() -> new ResourceNotFound("no record found for this id"));
    }

    @Override
    public UserDto findUserByUserName(String userName) {
        return repository.findByUsername(userName)
                .map(entity -> MapperUtil.map(entity, UserDto.class))
                .orElseThrow(() -> new ResourceNotFound("no record found for this name " + userName));
    }

    @Override
    public UserDto findUserByEmail(final String email) {
        return repository.findByEmail(email)
                .map(entity -> MapperUtil.map(entity, UserDto.class))
                .orElseThrow(() -> new ResourceNotFound("no record found for this email " + email));
    }

    @Override
    public UserDto addRole(final UserDto userDto) {
        return Optional.ofNullable(userDto)
                .map(this::getRoles)
                .map(this::registerUser)
                .orElseThrow(() -> new RuntimeException("Object Cannot be null"));

    }

    private UserDto getRoles(final UserDto userDto) {
        userDto.setRoles(userDto.getRoles().stream()
                .map(e -> roleService.findRoleById(e.getId()))
                .collect(Collectors.toSet()));
        return userDto;
    }
}
