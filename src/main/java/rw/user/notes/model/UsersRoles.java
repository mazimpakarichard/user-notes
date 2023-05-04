package rw.user.notes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS_ROLES")
public class UsersRoles {

	@Id
	private long user_id;

	private long role_id;

	public long getUser_id() {
		return user_id;
	}

	public long getRole_id() {
		return role_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}





}
