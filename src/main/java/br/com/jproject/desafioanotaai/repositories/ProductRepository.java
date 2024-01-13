package br.com.jproject.desafioanotaai.repositories;


import br.com.jproject.desafioanotaai.entity.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
