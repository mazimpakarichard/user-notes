package rw.user.notes.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
	@Column
	private String description;

	
	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;
	
	@JoinTable(
			name="roles_permissions",
			joinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="permission_id", referencedColumnName = "id"))
	
	private Collection<Permission> permissions;
}
