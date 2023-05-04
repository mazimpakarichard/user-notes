package rw.user.notes.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.user.notes.model.UserInfo;
import rw.user.notes.Services.*;
import rw.user.notes.exceptions.ResponseObject;

@RestController
@RequestMapping("/api/v1")
public class UserDetailsController {

	@Autowired
	private UserInfoService infoService;

	@GetMapping("/AllUsers")
	public ResponseObject findAllUserDetails() {
		try {
			List<UserInfo> userList = infoService.getAllUserInfo();
			if (userList.size() == 0) {
				return new ResponseObject(HttpStatus.NOT_FOUND, "no user found");
			} else {
				return new ResponseObject(HttpStatus.OK, userList);
			}
		} catch (Exception e) {
			return new ResponseObject(HttpStatus.NOT_FOUND, e);
		}

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserInfo> getUserDetailById(@PathVariable("id") UUID id) {
		try {

			UserInfo userFound = infoService.getUserInfoById(id);

			if (userFound == null) {
				throw new ApplicationContextException("The user doesn't exist with" + id);

//				return new ResponseEntity<>(userFound, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(userFound, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@PostMapping("/addUser")
	public ResponseEntity<UserInfo> addNewUser(@RequestBody UserInfo userDetails) {
		try {
			UserInfo newUser = infoService.AddNewUserInfo(userDetails);
			return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserInfo> updateUser(@PathVariable UUID id, @RequestBody UserInfo updatedUserDetail) {
		try {
			updatedUserDetail.setId(id);
			UserInfo newUser = infoService.updateUserInfo(updatedUserDetail);
			return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	@DeleteMapping("/deleteUser/{id}")

	public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
		try {
			infoService.deleteUserInfo(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
