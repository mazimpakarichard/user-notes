package rw.user.notes.Services;

import java.util.List;

import rw.user.notes.model.Permission;

public interface PermissionService {

	String pService="PermissionService";
	
	public List<Permission> getAllPermissions();
	public Permission getPermissionById(Long id);
	public Permission addNewPermission(Permission permission);
	public Permission updatePermission(Permission updatedPermission);
	public void deletePermission(Long id);
		
}
