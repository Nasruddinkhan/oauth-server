package com.mypractice.oauth.server.oauthserver.controller;

import com.mypractice.oauth.server.oauthserver.dto.ClientRegisterDto;
import com.mypractice.oauth.server.oauthserver.service.ClientRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public record ClientsController(ClientRegistrationService clientRegistrationService) {

    @GetMapping
    public ResponseEntity<List<ClientRegisterDto>> getClients() {
        return new ResponseEntity<>(clientRegistrationService.getClients(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<ClientRegisterDto> registerClients(@RequestBody final ClientRegisterDto registerDto) {
        final var clientRegisterDto = clientRegistrationService.registerClients(registerDto);
        return new ResponseEntity<>(clientRegisterDto, HttpStatus.CREATED);
    }


}
