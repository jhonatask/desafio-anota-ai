package br.com.jproject.desafioanotaai.mappers;


import br.com.jproject.desafioanotaai.dto.ProductDTO;
import br.com.jproject.desafioanotaai.entity.product.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapperDTO {

    ProductDTO productToProductDTO(Product entity);
    Product productDTOtoProduct(ProductDTO entity);
}
