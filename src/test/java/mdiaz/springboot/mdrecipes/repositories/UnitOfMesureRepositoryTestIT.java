package mdiaz.springboot.mdrecipes.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import mdiaz.springboot.mdrecipes.domain.UnitOfMesure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMesureRepositoryTestIT {

	@Autowired
	UnitOfMesureRepository unitOfMesureRepository;
	
	
	@Test
	public void testFindByDescription() {
		Optional<UnitOfMesure> uomOptional = unitOfMesureRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}
	
	@Test
	public void testFindByDescriptionCup() {
		Optional<UnitOfMesure> uomOptional = unitOfMesureRepository.findByDescription("Cup");
		assertEquals("Cup", uomOptional.get().getDescription());
	}

}
