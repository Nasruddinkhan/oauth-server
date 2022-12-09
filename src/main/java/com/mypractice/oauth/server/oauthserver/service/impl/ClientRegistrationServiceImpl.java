package com.mypractice.oauth.server.oauthserver.service.impl;

import com.mypractice.oauth.server.oauthserver.dto.ClientRegisterDto;
import com.mypractice.oauth.server.oauthserver.entity.ClientsDetails;
import com.mypractice.oauth.server.oauthserver.repository.ClientRegistrationRepository;
import com.mypractice.oauth.server.oauthserver.service.ClientRegistrationService;
import com.mypractice.oauth.server.oauthserver.util.MapperUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ClientRegistrationServiceImpl(
        PasswordEncoder bCryptPasswordEncoder,
        ClientRegistrationRepository clientRegistrationRepository) implements ClientRegistrationService {

    @Override
    public ClientRegisterDto registerClients(final ClientRegisterDto registerDto) {
        var clientDtl = MapperUtil.map(registerDto, ClientsDetails.class);
        clientDtl.setClientSecret("{bcrypt}" + bCryptPasswordEncoder.encode(registerDto.getClientSecret()));
        return MapperUtil.map(clientRegistrationRepository.save(clientDtl), ClientRegisterDto.class);
    }

    @Override
    public List<ClientRegisterDto> getClients() {
        return MapperUtil.mapAll(clientRegistrationRepository.findAll(), ClientRegisterDto.class);
    }
}
