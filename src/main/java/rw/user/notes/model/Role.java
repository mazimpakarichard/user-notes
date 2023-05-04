package rw.user.notes.model;


import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import rw.user.notes.enums.EURoles;



@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	private EURoles name;
	
	private String description;
	
	
	

	public EURoles getName() {
		return name;
	}



	public void setName(EURoles name) {
		this.name = name;
	}


	

	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}


}
