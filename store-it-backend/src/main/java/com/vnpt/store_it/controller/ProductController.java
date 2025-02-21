package com.vnpt.store_it.controller;

import com.vnpt.store_it.dtos.request.UpsertProductRequest;
import com.vnpt.store_it.dtos.response.ListProductResponse;
import com.vnpt.store_it.model.Product;
import com.vnpt.store_it.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("api/v1/product")
    public ResponseEntity<List<ListProductResponse>> getProduct() {
        return ResponseEntity.ok(productService.getListProducts());
    }

    @DeleteMapping("api/v1/product/{id}")
    public ResponseEntity<Boolean> deleteProduct(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(productService.delete(id));
    }

    @PostMapping("api/v1/product")
    public ResponseEntity<Product> upsertProduct(
            @RequestBody UpsertProductRequest request
            ) {
        log.info("Upsert product: {}", request);
        return ResponseEntity.ok(productService.upsert(request));
    }
}
