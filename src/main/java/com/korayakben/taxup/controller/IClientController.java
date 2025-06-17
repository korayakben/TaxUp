package com.korayakben.taxup.controller;

import com.korayakben.taxup.dto.clientDto.ClientDto;
import com.korayakben.taxup.dto.clientDto.ClientDtoIU;

public interface IClientController {
	
	ClientDto registerClient(ClientDtoIU clientDtoIU);

	boolean authClient(ClientDtoIU clientDtoIU);

}
