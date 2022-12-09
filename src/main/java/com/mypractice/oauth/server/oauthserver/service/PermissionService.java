package com.mypractice.oauth.server.oauthserver.service;

import com.mypractice.oauth.server.oauthserver.dto.PermissionDto;

import java.util.List;

public interface PermissionService {
     List<PermissionDto> findAllPermission();
     PermissionDto createPermission(final PermissionDto commonDto);
     PermissionDto findPermissionById(final Integer permissionId);
     PermissionDto findPermissionByName(final String name);
     List<PermissionDto> createPermissions(final List<PermissionDto> permissionDtos);
}
