package com.korayakben.taxup.dto.productDto;

import com.korayakben.taxup.entities.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoIU {

	private String name;
	
	private Double price;
	
	private Client client; 
	
}
