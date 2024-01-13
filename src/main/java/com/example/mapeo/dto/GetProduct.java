package com.example.mapeo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetProduct {
    private Long productId;

    private String productName;

    private String createdAt;

    private GetCategory productCategory;

    private String price;
}
