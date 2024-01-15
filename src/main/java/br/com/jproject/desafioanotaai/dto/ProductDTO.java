package br.com.jproject.desafioanotaai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private CategoryDTO category;

}
