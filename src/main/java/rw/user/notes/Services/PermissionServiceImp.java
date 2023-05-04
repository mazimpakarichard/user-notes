package rw.user.notes.Services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.user.notes.dao.PermissionDao;
import rw.user.notes.model.Permission;


@Service(PermissionService.pService)
public class PermissionServiceImp implements PermissionService {

	@Autowired
private PermissionDao permissionDao;

	@Override
	public List<Permission> getAllPermissions() {
		try {
			return permissionDao.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		
	}

	@Override
	public Permission getPermissionById(Long id) {
		try {
			return permissionDao.getById(id);
		} catch (Exception e) {
			throw e;
		}
	
	}

	@Override
	public Permission addNewPermission(Permission permission) {
		try {
			return permissionDao.save(permission);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}



	@Override
	public void deletePermission(Long id) {
	try {
		permissionDao.deleteById(id);
	} catch (Exception e) {
		// TODO: handle exception
		throw e;
	}
	}

	@Override
	public Permission updatePermission(Permission updatedPermission) {
		try {
			return permissionDao.save(updatedPermission);
		} catch (Exception e) {
			throw e;
		}
		
		
	}


}
