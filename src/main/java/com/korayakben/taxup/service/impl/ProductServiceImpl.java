package com.korayakben.taxup.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korayakben.taxup.dto.dtoRequests.DeleteProductReqDto;
import com.korayakben.taxup.dto.dtoRequests.UpdateProductReqDto;
import com.korayakben.taxup.dto.dtoResponses.DeleteProductResDto;
import com.korayakben.taxup.dto.dtoResponses.TaxRateResDto;
import com.korayakben.taxup.dto.dtoResponses.UpdateProductResDto;
import com.korayakben.taxup.dto.productDto.ProductDto;
import com.korayakben.taxup.dto.productDto.ProductDtoIU;
import com.korayakben.taxup.entities.Client;
import com.korayakben.taxup.entities.Product;
import com.korayakben.taxup.exception.BaseException;
import com.korayakben.taxup.exception.ErrorType;
import com.korayakben.taxup.repository.IClientRepository;
import com.korayakben.taxup.repository.IProductRepository;
import com.korayakben.taxup.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private IClientRepository clientRepository;
	
	@Override
	public boolean isMyProduct(Long product_id, Long client_id) {
		Optional<Product> productOpt = productRepository.findById(product_id);
		if(!productOpt.isEmpty()) {
			Product product = productOpt.get();
			return product.getClient().getId() == client_id ? true : false;
		}
		else {
			throw new BaseException(ErrorType.PRODUCT_NOT_FOUND);
		}
	}
	
	@Override
	public ProductDto createProduct(ProductDtoIU productDtoIU) {
		Product product = new Product();		
		Optional<Client> clientOpt = clientRepository.findById(productDtoIU.getClient().getId());
				
		if(!clientOpt.isEmpty()) {
			product.setClient(clientOpt.get());
			BeanUtils.copyProperties(productDtoIU, product);
			productRepository.save(product);
			
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			return productDto;
		}
		else {
			throw new BaseException(ErrorType.CLIENT_NOT_FOUND);
		}
		
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> productList = productRepository.findAll();
		List<ProductDto> dtoList = new ArrayList<>();
		for(Product product : productList) {
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			dtoList.add(productDto);
		}
		return dtoList;
	}
	
	@Override
	public List<ProductDto> getClientBooks(Long client_İd) {
		
		Optional<Client> clientOpt = clientRepository.findById(client_İd);
		
		if(!clientOpt.isEmpty()) {
			List<Product> productList = productRepository.getClientBooks(client_İd);
			List<ProductDto> dtoList = new ArrayList<>();
			for(Product product: productList) {
				ProductDto productDto = new ProductDto();
				BeanUtils.copyProperties(product, productDto);
				dtoList.add(productDto);
			}
			
			return dtoList;
		}
		else {
			throw new BaseException(ErrorType.CLIENT_NOT_FOUND);
		}
		
	}
	
	@Override
	public UpdateProductResDto updateProductByID(Long product_id, UpdateProductReqDto updateProductReqDto) {
		
		Optional<Product> productOpt = productRepository.findById(product_id);
		
		if(!productOpt.isEmpty()) {
			
			UpdateProductResDto resDto = new UpdateProductResDto();
			
			boolean isMyProduct = isMyProduct(product_id, updateProductReqDto.getClient_id());
			
			if(isMyProduct) {
				
				Product product = productOpt.get();
				
				product.setName(updateProductReqDto.getProductDto().getName());
				product.setPrice(updateProductReqDto.getProductDto().getPrice());
				
				productRepository.save(product);
				
				ProductDto productDto = new ProductDto();
				
				BeanUtils.copyProperties(product, productDto);
				
				resDto.setProductDto(productDto);
				resDto.setMessage("Your product has successfully been updated.");
				
				return resDto;
			}
			else {
				throw new BaseException(ErrorType.UNAUTHORIZED_ATTEMPT);
			}
			
		}
		else {
			throw new BaseException(ErrorType.PRODUCT_NOT_FOUND);
		}
		
		
	}
	
	@Override
	public DeleteProductResDto deleteProductByID(Long product_id, DeleteProductReqDto deleteProductReqDto) {
		Optional<Product> productOpt = productRepository.findById(product_id);
		
		if(!productOpt.isEmpty()) {
			
			DeleteProductResDto resDto = new DeleteProductResDto();
			
			boolean isMyProduct = isMyProduct(product_id, deleteProductReqDto.getClient_id());
			
			if(isMyProduct) {
				
				Product product = productOpt.get();
								
				ProductDto productDto = new ProductDto();
				
				BeanUtils.copyProperties(product, productDto);
				
				resDto.setProductDto(productDto);
				
				productRepository.deleteById(product.getId());;
				
				resDto.setMessage("Your product has successfully been deleted.");
				
				return resDto;
			}
			else {
				throw new BaseException(ErrorType.UNAUTHORIZED_ATTEMPT);
			}
			
		}
		else {
			throw new BaseException(ErrorType.PRODUCT_NOT_FOUND);
		}
	}
	
	
	@Override
	public TaxRateResDto calculateTaxByID(Long product_id) {
		Optional<Product> productOpt = productRepository.findById(product_id);
		
		if(!productOpt.isEmpty()) {
			
			Product product = productOpt.get();
			
			double price = product.getPrice();
			
			double taxRate;
			
			if (price <= 100) {
		        taxRate = 0.10;
		    } else if (price <= 500) {
		        taxRate = 0.15;
		    } else if (price <= 1000) {
		        taxRate = 0.18;
		    } else {
		        taxRate = 0.25;
		    }
			
			double tax_price = price * taxRate;
			double total_price = price + tax_price;
			
			ProductDto productDto = new ProductDto();
			BeanUtils.copyProperties(product, productDto);
			
			TaxRateResDto taxRateResDto = new TaxRateResDto();
			taxRateResDto.setProductDto(productDto);
			taxRateResDto.setTaxRate(taxRate);
			taxRateResDto.setTax(tax_price);
			taxRateResDto.setTotal_price(total_price);
			
			return taxRateResDto;
		}
		else {
			throw new BaseException(ErrorType.PRODUCT_NOT_FOUND);
		}		
	}
	
}
