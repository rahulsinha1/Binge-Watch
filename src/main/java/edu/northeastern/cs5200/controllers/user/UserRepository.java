package edu.northeastern.cs5200.controllers.user;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository
	extends JpaRepository<UserObject, Integer> {

	@Override
    @Query("select u from user u")
    List<UserObject> findAll();
}
