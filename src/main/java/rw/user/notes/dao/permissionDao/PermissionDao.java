package rw.user.notes.dao.permissionDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rw.user.notes.model.Permission;

@Repository
public interface PermissionDao extends JpaRepository<Permission, Long> {

	@Query("SELECT u from Permission u where u.name= :name")
	 Permission findPermissionByName(@Param("name")String name);

	@Query("SELECT a from Permission")
	 List<Permission> findAllPermissions();

	@Modifying
	@Query("INSERT INTO Permission (name) VALUES (:name)")
	Permission createPermission(@Param("name") String name, String description);

	@Modifying
	@Query(
			"UPDATE Permission u SET u.name = :newValue, u.description = :newValue WHERE u.id = :id")
	 Permission updatePermissionById(@Param("id") Long id, @Param("newValue") String newValue);

	@Modifying
	@Query("DELETE FROM Permission WHERE id = :id")
	void deletePermissionById(@Param("id") Long id);
	
}
