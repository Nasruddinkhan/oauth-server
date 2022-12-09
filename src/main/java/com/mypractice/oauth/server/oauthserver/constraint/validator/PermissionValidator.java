package com.mypractice.oauth.server.oauthserver.constraint.validator;

import com.mypractice.oauth.server.oauthserver.constraint.PermissionConstraint;
import com.mypractice.oauth.server.oauthserver.dto.PermissionDto;
import com.mypractice.oauth.server.oauthserver.repository.PermissionRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public record PermissionValidator(PermissionRepository permissionRepository) implements ConstraintValidator<PermissionConstraint, PermissionDto> {
    @Override
    public void initialize(PermissionConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final PermissionDto dto, final ConstraintValidatorContext context) {
        return Optional.ofNullable(dto.getId())
                                    .map(e -> permissionRepository.findByName(dto.getName()))
                                    .map(Optional::isPresent)
                                    .orElse(false);
    }
}
