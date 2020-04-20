package edu.northeastern.cs5200.repository;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Table;
import javax.transaction.Transactional;

import edu.northeastern.cs5200.model.User;

public interface UserRepository
	extends JpaRepository<User, Integer> {

	@Query("select u from User u where username = ?1")
	public User findByUserName(String username);


	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.firstName = :firstName, u.lastName = :lastName, u.email = :email," +
					"u.pass =:pass where u.username = :username")
	public void updateUser(@Param("firstName") String firstName , @Param("lastName") String lastName,
									@Param("email") String email,@Param("pass") String pass,
									@Param("username") String username);

	/*@Modifying
	@Query("update User u set u.firstName = ?1, u.lastName = ?2 where u.id = ?1")
	public User update(String username, User user);*/
}
