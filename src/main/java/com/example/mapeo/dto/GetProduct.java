package com.example.mapeo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetProduct {
    private Long id;

    private String name;

    private String createdAt;

    private GetCategory category;
}
