package rw.user.notes.dao;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rw.user.notes.model.Role;


@Repository
public interface RoleDao extends JpaRepository<Role, String> {
	
	@Query("SELECT u from Role u where u.name= :name")
	 Role findRoleByName(@Param("name")String name);

	@Query("SELECT a from Role a")
	 List<Role> findAllRoles();

	void deleteById(UUID id);

	Role getById(UUID id);


//	@Modifying
//	@Query("INSERT INTO Role (name,description) VALUES (:name,:description)")
//	Role createRole(@Param("name") String name, @Param("description") String description);
//
//	@Modifying
//	@Query(
//			"UPDATE Role u SET u.name = :newValue, u.description = :newValue WHERE u.id = :id")
//	 Role updateRoleById(@Param("id") Long id, @Param("newValue") String newValue);
//
//	@Modifying
//	@Query("DELETE FROM Role WHERE id = :id")
//	void deleteRoleById(@Param("id") Long id);
}
