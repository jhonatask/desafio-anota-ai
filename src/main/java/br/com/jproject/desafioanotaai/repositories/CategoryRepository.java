package br.com.jproject.desafioanotaai.repositories;

import br.com.jproject.desafioanotaai.entity.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
