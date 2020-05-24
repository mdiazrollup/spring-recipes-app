package mdiaz.springboot.mdrecipes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"recipe"})
@Entity
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Not cascade because if i delete the notes i don't want to delete my recipe
	@OneToOne
	private Recipe recipe;
	
	@Lob  // For Blob
	private String recipeNotes;
	
	
}
