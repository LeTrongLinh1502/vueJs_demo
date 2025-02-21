package com.vnpt.store_it.dtos.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.vnpt.store_it.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListProductResponse {
    private Long id;
    private String name;
    private String mainImage;
    private String secondaryImage;
    private Double price;
    private Double originalPrice;
//    private Date createdAt;
//    private Date updatedAt;

    public static List<ListProductResponse> of(List<Product> products) {
        List<ListProductResponse> response = new ArrayList<>();
        for (Product product : products) {
            response.add(ListProductResponse.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .mainImage(product.getMainImage())
                            .secondaryImage(product.getSecondaryImage())
                            .price(product.getPrice())
                            .originalPrice(product.getOriginalPrice())
                    .build());
        }
        return response;
    }
}
