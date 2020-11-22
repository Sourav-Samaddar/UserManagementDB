package com.ss.userManagementDB.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ss.userManagementDB.dto.User;
import com.ss.userManagementDB.repository.UserRepository;
import com.ss.userManagementDB.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		List<User> userList = (List<User>) userRepository.findAll();
		logger.info("User List from DB: "+userList);
		return userList;
	}

	@Override
	public User findUserById(Long id) {
		User user = userRepository.findById(id).get();
		logger.info("User from DB: "+user);
		return user;
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
		logger.info("User added to DB: "+user);
	}

	@Override
	public String updateUser(Long id, String address) {
		userRepository.updateAddress(id, address);
		logger.info("User new id :"+id + " address: "+address);
		return "User new id :"+id + " address: "+address;
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		logger.info("User deleted from DB with id: "+id);
	}

	@Override
	public List<User> getAllUsersBasedOnGender(String gender) {
		return userRepository.getAllUsersBasedOnGender(gender);
	}

	@Override
	public List<User> findSortedUser(String sortedParam) {
		return (List<User>) userRepository.findAll(Sort.by(sortedParam));
	}

	@Override
	public List<User> getUsersByGenderAndSort(String gender, String sortParam) {
		return (List<User>) userRepository.getUsersByGenderAndSort(gender, Sort.by(sortParam));
	}

	@Override
	public Page<User> getAllUsersByPages(int pageNumber, int numberOfElementPerPage) {
		return userRepository.findAll(PageRequest.of(pageNumber, numberOfElementPerPage));
	}
	
	@Override
	public Slice<User> getAllUsersBySlice(int pageNumber, int numberOfElementPerPage) {
		return userRepository.findAll(PageRequest.of(pageNumber, numberOfElementPerPage));
	}

}
