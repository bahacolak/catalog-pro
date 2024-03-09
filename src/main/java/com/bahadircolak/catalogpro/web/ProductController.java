package com.bahadircolak.catalogpro.web;

import com.bahadircolak.catalogpro.service.ProductService;
import com.bahadircolak.catalogpro.web.request.CreateProductRequest;
import com.bahadircolak.catalogpro.web.request.UpdateProductRequest;
import com.bahadircolak.catalogpro.web.response.ProductResponse;
import com.bahadircolak.catalogpro.web.response.ProductsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{productId}")
    public ProductResponse retrieveProduct(@PathVariable Long productId) {
        return ProductResponse.builder()
                .product(productService.retrieveProductById(productId))
                .build();
    }

    @GetMapping("/products")
    public ProductsResponse retrieveAllProducts() {
        return ProductsResponse.builder()
                .products(productService.retrieveAllProducts())
                .build();
    }

    @PostMapping("/product")
    public ProductResponse createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return ProductResponse.builder()
                .product(productService.createProduct(createProductRequest))
                .build();

    }

    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/product/{productId}")
    public void updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequest updateProductRequest) {
        productService.updateProduct(productId, updateProductRequest);
    }
}
