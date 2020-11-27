package br.com.rodrigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.modelo.Pessoa;
import br.com.rodrigo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	PessoaService ps;

	@PostMapping
	public Pessoa create(@RequestBody Pessoa pessoa) {
		return ps.create(pessoa);
	}

	@GetMapping("/{id}")
	public Pessoa readById(@PathVariable("id") Long id) {
		return ps.readById(id);
	}
	
	@GetMapping
	public List<Pessoa> readAll(){
		return ps.readAll();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		ps.deletePessoa(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
	public Pessoa update(@RequestBody Pessoa p) {
		return ps.alteraPessoa(p);
	}

}
