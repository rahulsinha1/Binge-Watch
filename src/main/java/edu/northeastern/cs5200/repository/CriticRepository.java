package edu.northeastern.cs5200.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

import edu.northeastern.cs5200.model.Critic;


public interface CriticRepository extends JpaRepository<Critic, Integer> {

  @Query("select c from Critic c where username = ?1")
  public Critic findByCriticName(String criticName);



  @Modifying
  @Transactional
  @Query("UPDATE Critic u SET u.firstName = :firstName, u.lastName = :lastName, u.email = :email," +
          "u.pass =:pass , u.company =:company where u.username = :criticname")
  public void updateCritic(@Param("firstName") String firstName , @Param("lastName") String lastName,
                         @Param("email") String email, @Param("pass") String pass, @Param("company") String company,
                         @Param("criticname") String criticname);

  @Query("SELECT critic fROM Critic critic WHERE critic.username=:criticname and critic.pass=:pass")
  public Critic FindCriticByCredentials(
          @Param("criticname") String criticname,
          @Param("pass") String pass
  );
}
