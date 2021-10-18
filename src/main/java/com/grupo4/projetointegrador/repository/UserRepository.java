package com.grupo4.projetointegrador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo4.projetointegrador.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	@Query("SELECT obj FROM UserModel obj WHERE UPPER(obj.email) LIKE CONCAT('%',UPPER(:email),'%')")
	Optional<UserModel> findByEmail(@Param("email") String email);

}
