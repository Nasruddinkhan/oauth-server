package com.mypractice.oauth.server.oauthserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisterDto {

    private String clientId;
    private String clientSecret;
    private String resourceIdS;
    private String scope;
    private String webServerRedirectId;
    private String authorities;
    private String authorizedGrantTypes;
    private int accessTokenValidity;
    private int refreshTokenValidity;
    private String additionalInformation;
    private String autoApprove;

}
