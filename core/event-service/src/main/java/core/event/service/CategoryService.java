package core.event.service;

import core.api.dto.category.CategoryDto;
import core.api.dto.category.NewCategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll(int from, int size);

    CategoryDto getById(Long categoryId);

    void delete(long categoryId);

    CategoryDto createCategory(NewCategoryDto dto);

    CategoryDto updateCategory(CategoryDto dto);
}
