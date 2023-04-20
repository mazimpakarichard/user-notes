package rw.user.notes.dao.userDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rw.user.notes.model.User;
  
@Repository
public interface UserDao extends JpaRepository<User, Long>{


@Query("SELECT u from User u where u.name= :name")
 User findUserByName(@Param("name")String name);

@Query("SELECT a from User")
 List<User> findAllUsers();

@Modifying
@Query("INSERT INTO User (name,email,password) VALUES (:name,:email,:password)")
User createUser(@Param("name") String name, @Param("email") String email, @Param("password") String password);

@Modifying
@Query(
		"UPDATE User u SET u.name = :newValue,u.email = :newValue , u.password = :newValue WHERE u.id = :id")
 User updateUserById(@Param("id") Long id, @Param("newValue") String newValue);

@Modifying
@Query("DELETE FROM User WHERE id = :id")
void deleteuserById(@Param("id") Long id);
 
 
}
