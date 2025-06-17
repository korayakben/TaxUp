package com.korayakben.taxup.dto.dtoResponses;

import com.korayakben.taxup.dto.productDto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxRateResDto {
	
	private ProductDto productDto;
	
	private double taxRate;
	
	private double tax;
	
	private double total_price;
}
