package com.vnpt.store_it.service;

import com.vnpt.store_it.dtos.request.UpsertProductRequest;
import com.vnpt.store_it.dtos.response.ListProductResponse;
import com.vnpt.store_it.model.Product;
import com.vnpt.store_it.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ListProductResponse> getListProducts() {
        return ListProductResponse.of(productRepository.findAll());
    }

    @Override
    public Boolean delete(Long id) {
       try {
           productRepository.deleteById(id);
           return Boolean.TRUE;
       } catch (Exception e) {
           log.error("Sản phẩm không tồn tại với ID: - {} ", id, e);
           return Boolean.FALSE;
       }
    }

    @Override
    public Product upsert(UpsertProductRequest request) {
        Product product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .mainImage(request.getMainImage())
                .secondaryImage(request.getSecondaryImage())
                .price(request.getPrice())
                .originalPrice(request.getOriginalPrice())
                .build();
        return productRepository.save(product);
    }
}
