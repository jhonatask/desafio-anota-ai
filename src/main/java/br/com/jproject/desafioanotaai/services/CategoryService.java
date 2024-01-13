package br.com.jproject.desafioanotaai.services;


import br.com.jproject.desafioanotaai.core.exceptions.category.CategoryNotFoundExcepiton;
import br.com.jproject.desafioanotaai.dto.CategoryDTO;
import br.com.jproject.desafioanotaai.entity.category.Category;
import br.com.jproject.desafioanotaai.mappers.CategoryMapperDTO;
import br.com.jproject.desafioanotaai.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapperDTO categoryMapperDTO;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapperDTO categoryMapperDTO) {
        this.categoryRepository = categoryRepository;
        this.categoryMapperDTO = categoryMapperDTO;
    }

    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category category = categoryMapperDTO.categoryDTOtoCategory(categoryDTO);
        category.setTitle(category.getTitle());
        category.setDescription(category.getDescription());
        category.setOwnerId(category.getOwnerId());
        categoryRepository.save(category);
        return categoryMapperDTO.categoryToCategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapperDTO::categoryToCategoryDTO).toList();
    }

    public CategoryDTO updateCategory(String id, CategoryDTO categoryData) {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundExcepiton::new);
        if (!categoryData.getTitle().isEmpty()) category.setTitle(categoryData.getTitle());
        if (!categoryData.getDescription().isEmpty()) category.setDescription(categoryData.getDescription());
        categoryRepository.save(category);
        return categoryMapperDTO.categoryToCategoryDTO(category);
    }

    public void deleteCategory(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundExcepiton::new);
        categoryRepository.delete(category);

    }

    public Optional<Category> findCategory(String id){
        return categoryRepository.findById(id);
    }
}
