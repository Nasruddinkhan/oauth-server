package com.mypractice.oauth.server.oauthserver.service;

import com.mypractice.oauth.server.oauthserver.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(final RoleDto roleDto);
    List<RoleDto> findAllRoles();
    List<RoleDto> createRole(final List<RoleDto> roleDto);
    RoleDto findRoleById(final Integer roleId);
    RoleDto findRoleByName(String name);
}
