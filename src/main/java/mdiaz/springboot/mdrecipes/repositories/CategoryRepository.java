package mdiaz.springboot.mdrecipes.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mdiaz.springboot.mdrecipes.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	Optional<Category> findByDescription(String description);
}
