package br.com.rodrigo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.converter.DozerConverter;
import br.com.rodrigo.modelo.Pessoa;
import br.com.rodrigo.modelo.vo.PessoaVO;
import br.com.rodrigo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	PessoaService ps;

	@PostMapping(produces = {"application/json","application/xml", "application/x-yaml"}, consumes = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO create(@RequestBody PessoaVO pessoaVO) {
		var entity = DozerConverter.parseObject(pessoaVO, Pessoa.class);
		var vo = DozerConverter.parseObject(ps.create(entity), PessoaVO.class);
		return vo;
	}

	@GetMapping(value="/{id}", produces = {"application/json","application/xml", "application/x-yaml"} )
	public PessoaVO readById(@PathVariable("id") Long id) {
		Pessoa pessoa = ps.readById(id);
		PessoaVO pessoaVO = new PessoaVO();
		pessoaVO.convertPessoaToPessoaVO(pessoa);
		return pessoaVO;
	}
	
	@GetMapping(produces = {"application/json","application/xml", "application/x-yaml" })
	public List<PessoaVO> readAll(){
		List<PessoaVO> pessoasVO = new ArrayList<PessoaVO>();
		List<Pessoa> pessoas = ps.readAll();
		for (Pessoa aux : pessoas) {
			PessoaVO pessoaVO = new PessoaVO();
			pessoaVO.convertPessoaToPessoaVO(aux);
			pessoasVO.add(pessoaVO);
		}
		return pessoasVO;
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		ps.deletePessoa(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(produces = {"application/json","application/xml" , "application/x-yaml"}, consumes = {"application/json","application/xml", "application/x-yaml"})
	public PessoaVO update(@RequestBody PessoaVO p) {
		Pessoa pessoa = new Pessoa();
		pessoa.convertPessoaVOToPessoa(p);
		Pessoa pessoaAlterada = ps.alteraPessoa(pessoa);
		 p.convertPessoaToPessoaVO(pessoaAlterada);
		 return p;
	}

}
