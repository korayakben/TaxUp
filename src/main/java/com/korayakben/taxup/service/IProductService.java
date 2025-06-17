package com.korayakben.taxup.service;

import java.util.List;

import com.korayakben.taxup.dto.dtoRequests.DeleteProductReqDto;
import com.korayakben.taxup.dto.dtoRequests.UpdateProductReqDto;
import com.korayakben.taxup.dto.dtoResponses.DeleteProductResDto;
import com.korayakben.taxup.dto.dtoResponses.TaxRateResDto;
import com.korayakben.taxup.dto.dtoResponses.UpdateProductResDto;
import com.korayakben.taxup.dto.productDto.ProductDto;
import com.korayakben.taxup.dto.productDto.ProductDtoIU;

public interface IProductService {

	ProductDto createProduct(ProductDtoIU productDtoIU);
	
	List<ProductDto> getAllProducts();
	
	List<ProductDto> getClientBooks(Long client_İd);
	
	UpdateProductResDto updateProductByID(Long product_id, UpdateProductReqDto updateProductReqDto);
	
	DeleteProductResDto deleteProductByID(Long product_id, DeleteProductReqDto deleteProductReqDto);

	TaxRateResDto calculateTaxByID(Long product_id);
	
	boolean isMyProduct(Long product_id, Long client_id);
}
