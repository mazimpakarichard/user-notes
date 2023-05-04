package rw.user.notes.dao;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import rw.user.notes.model.User;
import rw.user.notes.model.UserInfo;

  
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, UUID>{


@Query("SELECT u from UserDetails u where u.firstName= :firstName")
UserInfo findUserByFirstName(@Param("firstName")String firstName);

//@Query("SELECT a from User a")
// List<User> findAllUsers();

@Modifying
@Query("INSERT INTO UserDetails (firstName,lastName, email) VALUES (:firstName,:lastName,:email)")
UserInfo createUserDetails(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email);

@Modifying
@Query(
		"UPDATE UserDetails u SET u.firstName = :newValue,u.lastName = :newValue , u.email = :newValue WHERE u.id = :id")
UserInfo updateUserDetailsById(@Param("id") Long id);

@Modifying
@Query("DELETE FROM UserDetails WHERE id = :id")
void deleteUserDetailsById(@Param("id") Long id);
 
 
}
