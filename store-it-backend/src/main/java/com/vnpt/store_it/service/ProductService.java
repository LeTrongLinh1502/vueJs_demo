package com.vnpt.store_it.service;

import com.vnpt.store_it.dtos.request.UpsertProductRequest;
import com.vnpt.store_it.dtos.response.ListProductResponse;
import com.vnpt.store_it.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ListProductResponse> getListProducts();

    Boolean delete(Long id);

    Product upsert(UpsertProductRequest request);
}
