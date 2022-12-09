package com.mypractice.oauth.server.oauthserver.constraint;
import com.mypractice.oauth.server.oauthserver.constraint.validator.PermissionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = { PermissionValidator.class })
@Target({ TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionConstraint {
    String message() default "permission name is already exist ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field();

}
