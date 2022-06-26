package it16306.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it16306.assignment.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query("SELECT entity FROM Account entity WHERE email=:email")
	public Account findByEmail(@Param("email") String email);
	
	@Query(value = "SELECT acc FROM Account acc WHERE acc.id = :id ") 
	public Account findbyid(@Param("id") int id);
}
