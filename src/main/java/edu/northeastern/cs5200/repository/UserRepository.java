package edu.northeastern.cs5200.repository;

import edu.northeastern.cs5200.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


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
	@Query("SELECT user fROM User user WHERE user.username=:username and user.pass=:pass")
	public User FindUserByCredentials(
			@Param("username") String username,
			@Param("pass") String pass
	);

	/*@Modifying
	@Query("update User u set u.firstName = ?1, u.lastName = ?2 where u.id = ?1")
	public User update(String username, User user);*/
}
