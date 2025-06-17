package com.korayakben.taxup.service;

import com.korayakben.taxup.dto.clientDto.ClientDto;
import com.korayakben.taxup.dto.clientDto.ClientDtoIU;

public interface IClientService {

	ClientDto registerClient(ClientDtoIU clientDtoIU);
	
	boolean authClient(ClientDtoIU clientDtoIU);
	
	boolean usernameExists(String username);
}
