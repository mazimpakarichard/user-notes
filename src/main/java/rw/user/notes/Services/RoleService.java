package rw.user.notes.Services;

import java.util.List;
import java.util.UUID;

import rw.user.notes.model.Role;

public interface RoleService {

	String rService="RoleServiceImp";
	
	public List<Role> getAllRoles();
	public Role getRoleById(UUID id);
	public Role addNewRole(Role role);
	public Role updateRole(Role updatedRole);
	public void deleteRole(UUID id);
}
