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
import jakarta.persistence.Table;
import rw.user.notes.dao.userDao.UserDao;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
 
    private String name;
 
    private String email;
  
    private String password;
    
   public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	

public User(long id, String name, String email, String password, Collection<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}


public User(String name, String email, String password) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
}

public User(long id) {
	super();
	this.id = id;
}


@Override
public String toString() {
	return "User [name=" + name + ", email=" + email + ", password=" + password + ", roles=" + roles + "]";
}


@ManyToMany
   @JoinTable(
		   name="users_roles",
		   joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
		   inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
   
   private Collection<Role> roles;
    
    
}
