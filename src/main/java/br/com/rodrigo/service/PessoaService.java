package br.com.rodrigo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.rodrigo.modelo.Pessoa;

@Service
public class PessoaService {
	
	
	//Como ainda nao estamos usando o banco de dados, vamos gerar um valor para ID automaticamente
	private final AtomicLong idGerado = new AtomicLong();
	
	public Pessoa create (Pessoa p) {
		p.setId(idGerado.incrementAndGet());
		return p;
	}
	
	public Pessoa readById(Long id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(idGerado.incrementAndGet());
		pessoa.setNome("Rodrigo");
		pessoa.setSobrenome("Franco");
		pessoa.setSexo("Masculino");
		pessoa.setEndereco("Rua Mariana Jacinta");
		return pessoa;
	}
	
	public List<Pessoa> readAll (){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		for (int i = 0; i < 10; i++) {
			Pessoa p = criaPessoa(i);
			pessoas.add(p);
		}
		return pessoas;
	}

	private Pessoa criaPessoa(int i) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(idGerado.incrementAndGet());
		pessoa.setNome("Pessoa " + i);
		pessoa.setSobrenome("Sobrenome " + i);
		pessoa.setSexo("Masculino");
		pessoa.setEndereco("Brasil");
		return pessoa;
	}
	
	public void deletePessoa(Long id) {
		
	}
	
	public Pessoa alteraPessoa(Pessoa p) {
		return p;
	}

}
