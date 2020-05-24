package mdiaz.springboot.mdrecipes.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"recipe"})
@Entity
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	
	@ManyToOne
	private Recipe recipe;
	
	
	// We don't add to unitmesure because is in one direction. I don't want the child to have it
	//Eager only to be explicity said that we want it when loading the entity. Defaulf behaviour for OneToOne
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMesure uom;
	
	
	public Ingredient() {

	}
	
	public Ingredient(String description, BigDecimal amount, UnitOfMesure uom) {
		this.description = description;
		this.amount = amount;
		this.uom = uom;
	}





	
	
}
