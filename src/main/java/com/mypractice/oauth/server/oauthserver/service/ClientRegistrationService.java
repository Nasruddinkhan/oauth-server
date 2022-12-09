package com.mypractice.oauth.server.oauthserver.service;

import com.mypractice.oauth.server.oauthserver.dto.ClientRegisterDto;

import java.util.List;

public interface ClientRegistrationService {

    ClientRegisterDto registerClients(final ClientRegisterDto registerDto);

    List<ClientRegisterDto> getClients();
}
