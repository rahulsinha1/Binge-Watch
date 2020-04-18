package edu.northeastern.cs5200.repository;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.northeastern.cs5200.model.User;

public interface UserRepository
	extends JpaRepository<User, Integer> {

	@Query("select u from User u where username = ?1")
	public User findByUserName(String username);

	/*@Modifying
	@Query("update User u set u.firstName = ?1, u.lastName = ?2 where u.id = ?1")
	public User update(String username, User user);*/
}
