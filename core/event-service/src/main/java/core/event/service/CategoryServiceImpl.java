package core.event.service;

import core.api.dto.category.CategoryDto;
import core.api.dto.category.NewCategoryDto;
import core.api.exception.NotFoundException;
import core.event.entity.Category;
import core.event.mapper.CategoryMapper;
import core.event.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

import static core.event.mapper.CategoryMapper.dtoToCategory;
import static core.event.mapper.CategoryMapper.toCategoryDto;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void delete(long categoryId) {
        categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Категория id= " + categoryId + " не найдена"));
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryDto createCategory(@Validated NewCategoryDto dto) {
        return toCategoryDto(categoryRepository.save(dtoToCategory(dto)));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto dto) {

        Category category = categoryRepository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Категория id= " + dto.getId() + " не найдена"));
        category.setName(dto.getName());

        return toCategoryDto(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDto> getAll(int from, int size) {
        Pageable pageable = PageRequest.of(from > 0 ? from / size : 0, size);
        Page<Category> categoriesPage = categoryRepository.findAll(pageable);

        return categoriesPage.getContent().stream()
                .map(CategoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Категория id= " + categoryId + " не найдена"));

        return toCategoryDto(category);
    }
}
