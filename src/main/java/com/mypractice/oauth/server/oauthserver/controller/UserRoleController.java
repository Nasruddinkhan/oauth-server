package com.mypractice.oauth.server.oauthserver.controller;

import com.mypractice.oauth.server.oauthserver.dto.RoleDto;
import com.mypractice.oauth.server.oauthserver.repository.RoleRepository;
import com.mypractice.oauth.server.oauthserver.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public record UserRoleController(RoleRepository repository, RoleService roleService) {

    @GetMapping
    public ResponseEntity<List<RoleDto>> findAllRole() {
        return new ResponseEntity<>(roleService.findAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}/role-id")
    public ResponseEntity<RoleDto> findRoleById(@PathVariable("id") final Integer roleId) {
        return new ResponseEntity<>(roleService.findRoleById(roleId), HttpStatus.OK);
    }
    @GetMapping("/{name}/name")
    public ResponseEntity<RoleDto> findRoleByName(@PathVariable("name") final String name) {
        return new ResponseEntity<>(roleService.findRoleByName(name), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
    @PostMapping("/create")
    public ResponseEntity<List<RoleDto>> createRole(@RequestBody List<RoleDto> role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
    @PostMapping("/permission")
    public ResponseEntity<RoleDto> addPermissionToRole(@RequestBody RoleDto role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.OK);
    }
}
