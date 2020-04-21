//package edu.northeastern.cs5200.repository;
//
//import java.util.List;
//
//import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import edu.northeastern.cs5200.model.User;
//
//public interface UserRepository
//	extends JpaRepository<User, Integer> {
//
//	@Query("select user from User user where user.username = :username")
//	public User findByUserName(String username);
//}
