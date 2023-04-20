package rw.user.notes.domain;


import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
  
    private String name;
    private String email;
    private String password;
    
   @ManyToMany
   @JoinTable(
		   name="users_roles",
		   joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
		   inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
   
   private Collection<Role> roles;
    
    
}
