package mdiaz.springboot.mdrecipes.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mdiaz.springboot.mdrecipes.domain.UnitOfMesure;

public interface UnitOfMesureRepository extends CrudRepository<UnitOfMesure, Long>{

	Optional<UnitOfMesure> findByDescription(String description);
}
