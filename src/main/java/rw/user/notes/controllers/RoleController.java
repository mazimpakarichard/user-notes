package rw.user.notes.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.user.notes.Services.RoleService;
import rw.user.notes.model.Role;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@ExceptionHandler()
	@GetMapping("/allRoles")
	public ResponseEntity<List<Role>> allRoles() {
		try {
			List<Role> roles = roleService.getAllRoles();
			if (roles.isEmpty()) {
				throw new IllegalStateException("can't find the list of Roles");
//				throw new ApplicationRequestException("Can't find the list of all Roles");
			
			} else {
				
				return new ResponseEntity<>(roles, HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	

	}
    @GetMapping("/{id}")
//    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Role> getRoleById(@PathVariable UUID id) {
    	try {
    		Role role = roleService.getRoleById(id);
    		
    		return new ResponseEntity<>(role, HttpStatus.FOUND);
    	}catch (Exception e) {
			// TODO: handle exception3
    		throw e;
		}
        
    }
	
	@PostMapping("/addRole")
	public ResponseEntity<Role> CreateRole(@RequestBody Role role) {
		try {
			Role newRole = roleService.addNewRole(role);
			
//			throw new ApplicationRequestException("Can't add the role");
			return new ResponseEntity<>(newRole, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}
	@PutMapping("/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable UUID id, @RequestBody Role updatedRole){
		try {
			updatedRole.setId(id);
			Role newRole= roleService.updateRole(updatedRole);
			return ResponseEntity.ok(newRole);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

		
		
	}
	
//	@ExceptionHandler(UserNotFoundException.class)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable UUID id) {
		try {
//			Role role= roleService.getRoleById(id);
//			if(role == null) {
//				throw new userNotFoundException("User is not found with id" +id);
//			}
			roleService.deleteRole(id);
			 return ResponseEntity.noContent().build();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	

 
	
	

}
