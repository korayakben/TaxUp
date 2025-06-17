package com.korayakben.taxup.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korayakben.taxup.dto.HttpMethod;
import com.korayakben.taxup.dto.clientDto.ClientDto;
import com.korayakben.taxup.dto.clientDto.ClientDtoIU;
import com.korayakben.taxup.entities.Client;
import com.korayakben.taxup.exception.BaseException;
import com.korayakben.taxup.exception.ErrorType;
import com.korayakben.taxup.repository.IClientRepository;
import com.korayakben.taxup.service.IClientService;
import com.korayakben.taxup.utils.SecurityUtils;

@Service
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private IClientRepository clientRepo;
	
	@Autowired
	private SecurityUtils securityUtils;

	@Override
	public boolean usernameExists(String username) {
		Client testClient = clientRepo.getUserByUsername(username);
		return testClient == null ? false : true;
	}
	
	@Override
	public ClientDto registerClient(ClientDtoIU clientDtoIU) {
		Client client = new Client();
		boolean usernameExists = usernameExists(clientDtoIU.getUsername());
		if(!usernameExists) {
			clientDtoIU.setPassword(securityUtils.hashPassword(clientDtoIU.getPassword()));
			BeanUtils.copyProperties(clientDtoIU, client);
			clientRepo.save(client);
			
			ClientDto clientDto = new ClientDto();
			BeanUtils.copyProperties(client, clientDto);
			return clientDto;
		}
		else {
			// Exception Handling 
			throw new BaseException(ErrorType.USERNAME_EXISTS);
		}
	}
	
	@Override
	public boolean authClient(ClientDtoIU clientDtoIU) {
		Client client = clientRepo.getUserByUsername(clientDtoIU.getUsername());
		if(client != null) {
			System.out.println(client);
			boolean passwordsMatch = securityUtils.passwordsMatch(clientDtoIU.getPassword(), client.getPassword());
			return passwordsMatch ? true : false;
		}
		else {
			throw new BaseException(ErrorType.CLIENT_NOT_FOUND);
		}
	}
	
}
