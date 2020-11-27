package br.com.rodrigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.modelo.Pessoa;

@Repository
public interface PersonRepository extends JpaRepository<Pessoa, Long> {

}
