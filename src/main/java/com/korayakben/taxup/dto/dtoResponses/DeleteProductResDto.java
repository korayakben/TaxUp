package com.korayakben.taxup.dto.dtoResponses;

import com.korayakben.taxup.dto.productDto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductResDto {
		
	private ProductDto productDto;
	
	private String message;
	
}
