package rw.user.notes.model;



import java.util.Set;
import java.util.UUID;

import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration.Password;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_details")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	private String names;
	
	private String email;
	
	private String password;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "USERS_ROLES", 
	joinColumns = {@JoinColumn(name = "user_id",referencedColumnName="id")}, 
	inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName="id")})
	
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

		

	public String getNames() {
		return names;
	}

	public String getPassword() {
		return password;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public UserInfo() {
		super();
	}


	
	

}
