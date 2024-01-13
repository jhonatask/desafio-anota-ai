package br.com.jproject.desafioanotaai.mappers;

import br.com.jproject.desafioanotaai.dto.CategoryDTO;
import br.com.jproject.desafioanotaai.entity.category.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapperDTO {

    CategoryDTO categoryToCategoryDTO(Category entity);
    Category categoryDTOtoCategory(CategoryDTO entity);
}
