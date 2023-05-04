package rw.user.notes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rw.user.notes.Services.PermissionService;
import rw.user.notes.model.Permission;

@RestController
public class PermissionController {

	@Autowired
	PermissionService permissionService;
	
	@GetMapping("/allPermissions")
	public ResponseEntity<List<Permission>> GetAllPermissions() {
		try {
			List<Permission> permissions = permissionService.getAllPermissions();
			if (permissions.isEmpty()) {
				return new ResponseEntity<>(permissions, HttpStatus.NO_CONTENT);
			}else {
			return new ResponseEntity<>(permissions, HttpStatus.OK);
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@PostMapping("/createPermission/{id}")
	public ResponseEntity<Permission> createPermission(Long id, Permission permission) {
		try {
			Permission Newpermission= permissionService.addNewPermission(permission);
			return new ResponseEntity<> (Newpermission, HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	@PutMapping("/updatePermission/{id}")
	public	ResponseEntity<Permission> updatePermission(@PathVariable Long id, @RequestBody Permission updatedPermission) {
		try {

		Permission	newUpdatedPermission= permissionService.updatePermission(updatedPermission);
			return new ResponseEntity<> (newUpdatedPermission, HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@DeleteMapping("/deletePermission/{id}")
	public void deletePermission(Long id){
		try {
			permissionService.deletePermission(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	

		
	}
	

