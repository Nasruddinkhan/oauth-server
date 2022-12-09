package com.mypractice.oauth.server.oauthserver.service.impl;

import com.mypractice.oauth.server.oauthserver.dto.RoleDto;
import com.mypractice.oauth.server.oauthserver.entity.Role;
import com.mypractice.oauth.server.oauthserver.repository.RoleRepository;
import com.mypractice.oauth.server.oauthserver.service.RoleService;
import com.mypractice.oauth.server.oauthserver.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//@Transactional
@Service
public record RoleServiceImpl(RoleRepository repository) implements RoleService {
   // static BiFunction<Object, Class<Object>, Object> mapperFunction = (source, destination) -> MapperUtil.map(source, destination);
    @Override
    public RoleDto createRole(final RoleDto roleDto) {
        return Optional.ofNullable(roleDto)
                    .map(dto->MapperUtil.map(dto, Role.class))
                    .map(repository::save).map(entity->MapperUtil.map(entity, RoleDto.class))
                    .orElseThrow(()->new RuntimeException("Object cannot be null or empty"));
    }

    @Override
    public List<RoleDto> createRole(final List<RoleDto> roleDto) {
        return Optional.ofNullable(roleDto)
                .map(dto->MapperUtil.mapAll(dto, Role.class))
                .map(repository::saveAll).map(entity->MapperUtil.mapAll(entity, RoleDto.class))
                .orElseThrow(()->new RuntimeException("Object cannot be null or empty"));
    }

    @Override
    public RoleDto findRoleById(final Integer roleId) {
        return repository.findById(roleId)
                        .map(entity->MapperUtil.map(entity, RoleDto.class))
                        .orElseThrow(()->new RuntimeException("Record not present"));
    }

    @Override
    public RoleDto findRoleByName(final String name) {
        return   repository.findByName(name)
                            .map(entity->MapperUtil.map(entity, RoleDto.class))
                            .orElseThrow(()->new RuntimeException("Record not present"));
    }

    @Override
    public List<RoleDto> findAllRoles() {
        return Optional.of(repository.findAll())
                .map(o-> MapperUtil.mapAll(o, RoleDto.class))
                .orElseThrow(()->new RuntimeException("no record present"));
    }
}
