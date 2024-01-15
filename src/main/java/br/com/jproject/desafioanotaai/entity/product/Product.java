package br.com.jproject.desafioanotaai.entity.product;


import br.com.jproject.desafioanotaai.entity.category.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    private Integer price;
    private Category category;
    private String ownerId;
}
