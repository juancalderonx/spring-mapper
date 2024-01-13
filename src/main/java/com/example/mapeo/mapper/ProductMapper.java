package com.example.mapeo.mapper;

import com.example.mapeo.dto.GetProduct;
import com.example.mapeo.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        CategoryMapper.class,
})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "name", target = "productName"),
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "category", target = "productCategory"),
            @Mapping(source = "price", target = "price", numberFormat = "$0.00"),
    })
    GetProduct toGetDto(Product product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "createdAt", ignore = true),
    })
    Product toEntity(GetProduct getProduct);

    List<GetProduct> toGetProducts(List<Product> products);

    List<Product> toEntities(List<GetProduct> getProducts);

}
