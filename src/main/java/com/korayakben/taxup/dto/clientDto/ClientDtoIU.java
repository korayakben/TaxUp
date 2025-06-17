package com.korayakben.taxup.dto.clientDto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDtoIU {
	
	@Size(min = 3, max = 30, message = "Username value has to be in 3-30")
	private String username;
	
	@Size(min = 8, message = "Password value has to consist of minimum 8 digits")
	private String password;

}
