package com.korayakben.taxup.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korayakben.taxup.controller.IProductController;
import com.korayakben.taxup.dto.dtoRequests.DeleteProductReqDto;
import com.korayakben.taxup.dto.dtoRequests.UpdateProductReqDto;
import com.korayakben.taxup.dto.dtoResponses.DeleteProductResDto;
import com.korayakben.taxup.dto.dtoResponses.TaxRateResDto;
import com.korayakben.taxup.dto.dtoResponses.UpdateProductResDto;
import com.korayakben.taxup.dto.productDto.ProductDto;
import com.korayakben.taxup.dto.productDto.ProductDtoIU;
import com.korayakben.taxup.service.IProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductControllerImpl implements IProductController{

	@Autowired
	private IProductService productService;
	
	@PostMapping("/create")
	@Override
	public ProductDto createProduct(@RequestBody ProductDtoIU productDtoIU) {
		return productService.createProduct(productDtoIU);
	}
	
	@GetMapping("/all")
	@Override
	public List<ProductDto> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/all/{id}")
	@Override
	public List<ProductDto> getClientBooks(@PathVariable(name = "id", required = true) Long client_İd) {
		return productService.getClientBooks(client_İd);
	}
	
	@PutMapping("/update/{id}")
	@Override
	public UpdateProductResDto updateProductByID(@PathVariable(name = "id", required = true) Long product_id, @RequestBody UpdateProductReqDto updateProductReqDto) {
		return productService.updateProductByID(product_id, updateProductReqDto);
	}
	
	@DeleteMapping("/delete/{id}")
	@Override
	public DeleteProductResDto deleteProductByID(@PathVariable(name = "id", required = true) Long product_id, @RequestBody DeleteProductReqDto deleteProductReqDto) {
		return productService.deleteProductByID(product_id, deleteProductReqDto);
	}
	
	@GetMapping("/tax")
	@Override
	public TaxRateResDto calculateTaxByID(@RequestParam("productId") Long product_id) {
		return productService.calculateTaxByID(product_id);
	}
}
