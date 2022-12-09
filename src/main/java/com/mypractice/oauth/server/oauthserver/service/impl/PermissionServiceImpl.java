package com.mypractice.oauth.server.oauthserver.service.impl;

import com.mypractice.oauth.server.oauthserver.dto.PermissionDto;
import com.mypractice.oauth.server.oauthserver.entity.Permission;
import com.mypractice.oauth.server.oauthserver.exception.ResourceNotFound;
import com.mypractice.oauth.server.oauthserver.exception.UniqueConstraintException;
import com.mypractice.oauth.server.oauthserver.repository.PermissionRepository;
import com.mypractice.oauth.server.oauthserver.service.PermissionService;
import com.mypractice.oauth.server.oauthserver.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public record PermissionServiceImpl(PermissionRepository permissionRepository) implements PermissionService {

    @Override
    public PermissionDto createPermission(final PermissionDto permissionDto) {
        return  Optional.ofNullable(permissionDto)
                    .map(this::checkTheUniquePermission)
                    .map(dto  -> MapperUtil.map(dto, Permission.class))
                    .map(permissionRepository::save)
                    .map(entity-> MapperUtil.map(entity, PermissionDto.class))
                    .orElseThrow(() -> new RuntimeException("permission cannot be null or empty"));

    }

    @Override
    public PermissionDto findPermissionById(final Integer permissionId) {
        return permissionRepository.findById(permissionId)
                .map(entity->  MapperUtil.map(entity, PermissionDto.class))
                .orElseThrow(()-> new ResourceNotFound("Record not Present"));
    }

    @Override
    public PermissionDto findPermissionByName(final String name) {
        return permissionRepository.findByName(name)
                .map(entity->  MapperUtil.map(entity, PermissionDto.class))
                .orElseThrow(()-> new ResourceNotFound("Record not Present"));
    }

    @Override
    public List<PermissionDto> createPermissions(List<PermissionDto> permissionDtos) {
        final var permissionsDtos = permissionDtos.stream().map(this::checkTheUniquePermission)
                .collect(Collectors.toList());
        final var permissions = MapperUtil.mapAll(permissionsDtos, Permission.class);
        return MapperUtil.mapAll(permissionRepository.saveAll(permissions), PermissionDto.class);
    }

    private PermissionDto checkTheUniquePermission(final PermissionDto permissionDto) {
        if (Objects.isNull(permissionDto.getId()))
            permissionRepository.findByName(permissionDto.getName()).ifPresent(s -> {
                throw new UniqueConstraintException("Permission name already present");
            });
        return permissionDto;
    }

    @Override
    public List<PermissionDto> findAllPermission() {
        return MapperUtil.mapAll(permissionRepository.findAll(), PermissionDto.class);
    }
}
