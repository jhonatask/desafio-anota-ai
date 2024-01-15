package br.com.jproject.desafioanotaai.services;


import br.com.jproject.desafioanotaai.core.exceptions.category.CategoryNotFoundExcepiton;
import br.com.jproject.desafioanotaai.core.exceptions.product.ProductNotFoundException;
import br.com.jproject.desafioanotaai.dto.ProductDTO;
import br.com.jproject.desafioanotaai.entity.category.Category;
import br.com.jproject.desafioanotaai.entity.product.Product;
import br.com.jproject.desafioanotaai.mappers.ProductMapperDTO;
import br.com.jproject.desafioanotaai.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapperDTO productMapperDTO;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductMapperDTO productMapperDTO, ProductRepository productRepository, CategoryService categoryService) {
        this.productMapperDTO = productMapperDTO;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public ProductDTO create(ProductDTO productData) {
        Product product = productMapperDTO.productDTOtoProduct(productData);
        Category category = categoryService.findCategory(productData.getCategory().getId()).orElseThrow(CategoryNotFoundExcepiton::new);
        product.setTitle(productData.getTitle());
        product.setDescription(productData.getDescription());
        product.setPrice(productData.getPrice());
        product.setOwnerId(productData.getOwnerId());
        product.setCategory(category);
        productRepository.save(product);
        return productMapperDTO.productToProductDTO(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> categories = productRepository.findAll();
        return categories.stream().map(productMapperDTO::productToProductDTO).toList();
    }

    public ProductDTO updateProduct(String id, ProductDTO productData) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        if(productData.getCategory() != null){
            categoryService.findCategory(productData.getCategory().getId()).ifPresent(product::setCategory);
        }
        if(!productData.getTitle().isEmpty()) product.setTitle(productData.getTitle());
        if(!productData.getDescription().isEmpty()) product.setDescription(productData.getDescription());
        if(!(productData.getPrice() == null)) product.setPrice(productData.getPrice());
        if(!productData.getOwnerId().isEmpty()) product.setOwnerId(productData.getOwnerId());
        productRepository.save(product);
        return productMapperDTO.productToProductDTO(product);
    }

    public void deleteProduct(String id) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }
}
