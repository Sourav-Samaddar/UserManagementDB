package com.ss.userManagementDB.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import com.ss.userManagementDB.dto.User;

public interface UserService {

	List<User> findAllUsers();

	User findUserById(Long id);

	void addUser(User user);

	String updateUser(Long id, String address);

	void deleteUserById(Long id);

	List<User> getAllUsersBasedOnGender(String gender);

	List<User> findSortedUser(String sortedParam);
	
	List<User> getUsersByGenderAndSort(String gender, String sortParam);
	
	Page<User> getAllUsersByPages(int pageNumber,int numberOfElementPerPage);
	
	Slice<User> getAllUsersBySlice(int pageNumber,int numberOfElementPerPage);

}
