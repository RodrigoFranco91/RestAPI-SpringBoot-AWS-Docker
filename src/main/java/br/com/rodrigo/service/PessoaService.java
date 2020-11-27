package br.com.rodrigo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigo.exception.ResourceNotFoundException;
import br.com.rodrigo.modelo.Pessoa;
import br.com.rodrigo.repository.PersonRepository;

@Service
public class PessoaService {
	
	
	//Como ainda nao estamos usando o banco de dados, vamos gerar um valor para ID automaticamente
	//private final AtomicLong idGerado = new AtomicLong();
	
	@Autowired
	PersonRepository repositorio;
	
	public Pessoa create (Pessoa p) {
		return repositorio.save(p);
	}
	
	public Pessoa readById(Long id) {
		return repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com este id"));
	}
	
	public List<Pessoa> readAll (){
		return repositorio.findAll();
	}

	public void deletePessoa(Long id) {
		Pessoa p = repositorio.getOne(id);
		repositorio.delete(p);;
	}
	
	public Pessoa alteraPessoa(Pessoa p) {
		Pessoa entity = repositorio.getOne(p.getId());
		entity.setNome(p.getNome());
		entity.setSobrenome(p.getSobrenome());
		entity.setEndereco(p.getEndereco());
		entity.setSexo(p.getSexo());
		return repositorio.save(entity);
	}
	
	/*
	private Pessoa criaPessoa(int i) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(idGerado.incrementAndGet());
		pessoa.setNome("Pessoa " + i);
		pessoa.setSobrenome("Sobrenome " + i);
		pessoa.setSexo("Masculino");
		pessoa.setEndereco("Brasil");
		return pessoa;
	}
	*/

}
