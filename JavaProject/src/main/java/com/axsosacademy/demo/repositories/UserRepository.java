package com.axsosacademy.demo.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsosacademy.demo.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);

	@Query(value="SELECT *\r\n"
			+ "From users\r\n"
			+ "WHERE role_id = 1", nativeQuery=true)
	List<User> findNonAdmin();
}
