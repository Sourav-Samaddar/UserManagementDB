package com.ss.userManagementDB.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import com.ss.userManagementDB.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Transactional
	@Modifying
	@Query("Update User set address=:address where id =:id")
	void updateAddress(@Param("id") Long id, @Param("address") String address);
	
	@Query("select u from User u where u.gender =:gender")
	List<User> getAllUsersBasedOnGender(@Param("gender") String gender);
	
	@Query("select u from User u where u.gender =:gender")
	List<User> getUsersByGenderAndSort(@Param("gender") String gender,Sort sort);
}
