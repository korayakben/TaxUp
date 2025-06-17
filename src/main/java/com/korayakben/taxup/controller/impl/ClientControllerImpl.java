package com.korayakben.taxup.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korayakben.taxup.controller.IClientController;
import com.korayakben.taxup.dto.clientDto.ClientDto;
import com.korayakben.taxup.dto.clientDto.ClientDtoIU;
import com.korayakben.taxup.service.IClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/client")
public class ClientControllerImpl implements IClientController{
	
	@Autowired
	private IClientService clientService;

	@PostMapping("/register")
	@Override
	public ClientDto registerClient(@RequestBody @Valid ClientDtoIU clientDtoIU) {
		return clientService.registerClient(clientDtoIU);
	}
	
	@PostMapping("/auth")
	@Override
	public boolean authClient(@RequestBody ClientDtoIU clientDtoIU) {
		return clientService.authClient(clientDtoIU);
	}
	
}
