package com.example.mapeo.mapper;

import com.example.mapeo.dto.GetCategory;
import com.example.mapeo.entity.Category;
import com.example.mapeo.repository.CategoryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    abstract GetCategory toGetCategory(Category category);

    Category toEntity(GetCategory getCategory) {
        if(getCategory == null) return null;

        Category category = categoryRepository.findById(getCategory.getId()).
                orElse(null);

        if(category == null) return null;

        category.setId(getCategory.getId());
        category.setName(getCategory.getName());

        return category;
    }

    abstract List<GetCategory> toGetCategories(List<Category> categories);

    abstract List<Category> toEntities(List<GetCategory> getCategories);
}
