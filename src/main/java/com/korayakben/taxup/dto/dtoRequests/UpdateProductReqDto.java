package com.korayakben.taxup.dto.dtoRequests;

import com.korayakben.taxup.dto.productDto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductReqDto {

	private Long client_id;
	
	private ProductDto productDto;
	
}
