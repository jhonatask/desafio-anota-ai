package br.com.jproject.desafioanotaai.controllers;


import br.com.jproject.desafioanotaai.dto.CategoryDTO;
import br.com.jproject.desafioanotaai.dto.ProductDTO;
import br.com.jproject.desafioanotaai.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
     private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productData){
        ProductDTO product = productService.create(productData);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateCategory(@PathVariable String id, @RequestBody ProductDTO productData){
        ProductDTO product = productService.updateProduct(id,productData);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
