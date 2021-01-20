package br.com.rodrigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.rodrigo.modelo.Pessoa;

@Repository
public interface PersonRepository extends JpaRepository<Pessoa, Long> {

	@Modifying
	@Query("UPDATE Pessoa p SET p.enabled = false WHERE p.id =:id")
	void disablePerson(@Param("id") Long id);

}
