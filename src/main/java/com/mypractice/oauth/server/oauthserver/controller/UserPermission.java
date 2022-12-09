package com.mypractice.oauth.server.oauthserver.controller;

import com.mypractice.oauth.server.oauthserver.dto.CommonDto;
import com.mypractice.oauth.server.oauthserver.dto.PermissionDto;
import com.mypractice.oauth.server.oauthserver.service.PermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/permission")
public record UserPermission(PermissionService service) {

    @GetMapping
    public ResponseEntity<List<PermissionDto>> findAllPermission() {
        return new ResponseEntity<>(service.findAllPermission(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommonDto> createPermission(@RequestBody @Valid final PermissionDto permissionDto) {
        return new ResponseEntity<>(service.createPermission(permissionDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/permissionId")
    public ResponseEntity<PermissionDto> findPermissionById(@PathVariable("id") final Integer permissionId) {
        return new ResponseEntity<>(service.findPermissionById(permissionId), HttpStatus.OK);
    }
    @GetMapping("/{name}/name")
    public ResponseEntity<PermissionDto> findPermissionByName(@PathVariable final String name) {
        return new ResponseEntity<>(service.findPermissionByName(name), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<PermissionDto>> createPermissions(@RequestBody @Valid List<PermissionDto> permissionDtos) {
        return new ResponseEntity<>(service.createPermissions(permissionDtos), HttpStatus.CREATED);
    }
}
