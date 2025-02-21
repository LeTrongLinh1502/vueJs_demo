package com.vnpt.store_it.dtos.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpsertProductRequest {
    private Long id;
    private String name;
    private String mainImage;
    private String secondaryImage;
    private Double price;
    private Double originalPrice;
}
