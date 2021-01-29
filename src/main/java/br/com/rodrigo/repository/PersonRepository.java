package br.com.rodrigo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Query("SELECT p FROM Pessoa p WHERE p.nome LIKE LOWER(CONCAT ('%', :name, '%')) ")
	Page<Pessoa> findPessoaByName(@Param("name") String name, Pageable pageable);

}
