package com.nas.foodmenu.dto.mapper;


import com.nas.foodmenu.dto.CategoryDTO;
import com.nas.foodmenu.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {

    public abstract CategoryDTO toDto(Category category);
}
