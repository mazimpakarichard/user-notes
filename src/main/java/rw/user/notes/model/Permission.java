package rw.user.notes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import rw.user.notes.enums.EUPermissions;

@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private EUPermissions name;
	

	public long getId() {
		return id;
	}



	

	public void setId(long id) {
		this.id = id;
	}





	public EUPermissions getName() {
		return name;
	}





	public void setName(EUPermissions name) {
		this.name = name;
	}



	
	
}
