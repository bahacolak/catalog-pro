package com.bahadircolak.catalogpro.service;

import com.bahadircolak.catalogpro.model.Product;
import com.bahadircolak.catalogpro.repository.ProductRepository;
import com.bahadircolak.catalogpro.web.dto.ProductDto;
import com.bahadircolak.catalogpro.web.request.CreateProductRequest;
import com.bahadircolak.catalogpro.web.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto retrieveProductById(Long productId) {
        return productRepository.findById(productId)
                .map(Product::toDto)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + productId));
    }

    public List<ProductDto> retrieveAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(Product::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto createProduct(CreateProductRequest createProductRequest) {
        Product product = Product.builder()
                .name(createProductRequest.getName())
                .size(createProductRequest.getSize())
                .photoUrl(createProductRequest.getPhotoUrl())
                .skuCode(createProductRequest.getSkuCode())
                .build();

        Product savedProduct = productRepository.save(product);
        return savedProduct.toDto();
    }

    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new NoSuchElementException("Product not found with id: " + productId);
        }
        productRepository.deleteById(productId);
    }

    public void updateProduct(Long productId, UpdateProductRequest updateProductRequest) {

        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + productId));

        existingProduct.setName(updateProductRequest.getName());
        existingProduct.setSize(updateProductRequest.getSize());
        existingProduct.setSkuCode(updateProductRequest.getSkuCode());
        existingProduct.setPhotoUrl(updateProductRequest.getPhotoUrl());

        productRepository.save(existingProduct);
    }
}

