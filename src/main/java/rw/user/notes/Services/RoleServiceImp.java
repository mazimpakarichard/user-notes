package rw.user.notes.Services;



import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.user.notes.dao.RoleDao;
import rw.user.notes.model.Role;


@Service(RoleService.rService)
public class RoleServiceImp implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getAllRoles() {
		try {
		return roleDao.findAll();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Role addNewRole(Role role) {
try {
	return roleDao.save(role);
} catch (Exception e) {
	throw e;
}
	}


@Override
public Role updateRole(Role updatedRole) {
	try {
		return roleDao.save(updatedRole);
} catch (Exception e) {
			throw e;
	}
}

@Override
public Role getRoleById(UUID id) {
	try {
		return roleDao.getById(id);
		
	} catch (Exception e) {
		throw e;
	}
}

@Override
public void deleteRole(UUID id) {
	try {
		roleDao.deleteById(id);
	} catch (Exception e) {
		
		throw e;
	}
	
}

		
	}




		
