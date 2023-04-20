package rw.user.notes.dao.roleDao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rw.user.notes.model.Role;


@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
	
	@Query("SELECT u from Role u where u.name= :name")
	 Role findRoleByName(@Param("name")String name);

	@Query("SELECT a from Role")
	 List<Role> findAllRoles();

	@Modifying
	@Query("INSERT INTO Role (name,description) VALUES (:name,:description)")
	Role createRole(@Param("name") String name, @Param("description") String description);

	@Modifying
	@Query(
			"UPDATE Role u SET u.name = :newValue, u.description = :newValue WHERE u.id = :id")
	 Role updateRoleById(@Param("id") Long id, @Param("newValue") String newValue);

	@Modifying
	@Query("DELETE FROM Role WHERE id = :id")
	void deleteRoleById(@Param("id") Long id);
}
