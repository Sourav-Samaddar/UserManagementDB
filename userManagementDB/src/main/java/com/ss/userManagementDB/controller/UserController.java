package com.ss.userManagementDB.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ss.userManagementDB.dto.User;
import com.ss.userManagementDB.service.UserService;

@RestController
public class UserController {

	Logger log = LoggerFactory.getLogger("UserManagementDB");
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		log.info("getting User ***");
		return userService.findAllUsers();
	}
	
	@GetMapping("/user/{id}")
	@ResponseBody
	public User getUser(@PathVariable String id) {
		return userService.findUserById(Long.parseLong(id));
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		userService.addUser(user);
		URI path = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(path).build();
	}
	
	@PutMapping("/user/{id}")
	public String updateUser(@PathVariable Long id, @RequestParam String address) {
		return userService.updateUser(id, address);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUserById(Long.parseLong(id));
		return "User with id: "+ id + "deleted";
	}
	
	@GetMapping("/getAllUsersBasedOnGender/{gender}")
	public List<User> getAllUsersBasedOnGender(@PathVariable String gender){
		return userService.getAllUsersBasedOnGender(gender);
	}
	
	@GetMapping("/findSortedUser/{sortedParam}")
	public List<User> findSortedUser(@PathVariable String sortedParam){
		return userService.findSortedUser(sortedParam);
	}
	
	@GetMapping("/getUsersByGenderAndSort/{gender}/{sortedParam}")
	public List<User> getUsersByGenderAndSort(@PathVariable String gender,@PathVariable String sortedParam){
		return userService.getUsersByGenderAndSort(gender, sortedParam);
	}
	
	@GetMapping("/getAllUsersByPages/{pageNumber}/{numberOfElementPerPage}")
	public Page<User> getAllUsersByPages(@PathVariable String pageNumber,@PathVariable String numberOfElementPerPage){
		return userService.getAllUsersByPages(Integer.parseInt(pageNumber), Integer.parseInt(numberOfElementPerPage));
	}
	
	@GetMapping("/getAllUsersBySlice/{pageNumber}/{numberOfElementPerPage}")
	public Slice<User> getAllUsersBySlice(@PathVariable String pageNumber,@PathVariable String numberOfElementPerPage){
		return userService.getAllUsersBySlice(Integer.parseInt(pageNumber), Integer.parseInt(numberOfElementPerPage));
	}
}
