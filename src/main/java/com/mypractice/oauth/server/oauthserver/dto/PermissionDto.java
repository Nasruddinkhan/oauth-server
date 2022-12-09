package com.mypractice.oauth.server.oauthserver.dto;

import com.mypractice.oauth.server.oauthserver.constast.ApplicationConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@PermissionConstraint(field = "name")
public class PermissionDto extends CommonDto {
    @NotEmpty(message = ApplicationConstant.EMPTY_VLD)
    private String name;
}
