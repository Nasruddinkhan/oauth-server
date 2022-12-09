package com.mypractice.oauth.server.oauthserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "oauth_client_details")
public class ClientsDetails {

    @Id
    @Column(name = "client_id", length = 50)
    private String clientId;

    @Column(name = "client_secret", length = 200)
    private String clientSecret;

    @Column(name = "resource_ids")
    private String resourceIdS;

    @Column(name = "scope", length = 150)
    private String scope;

    @Column(name = "web_server_redirect_uri", length = 150)
    private String webServerRedirectId;

    @Column(name = "authorities", length = 150)
    private String authorities;

    @Column(name = "authorized_grant_types", length = 100)
    private String authorizedGrantTypes;

    @Column(name = "access_token_validity")
    private int accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private int refreshTokenValidity;

    @Lob
    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "autoapprove" , length = 50)
    private String autoApprove;


}
