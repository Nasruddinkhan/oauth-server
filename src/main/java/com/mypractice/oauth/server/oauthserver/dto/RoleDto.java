package com.mypractice.oauth.server.oauthserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDto extends CommonDto {
    private List<CommonDto> permissions;
}
