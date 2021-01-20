package br.com.rodrigo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value = "Pessoa End-point", description = "Descrição para pessoa", tags = { "Pessoa TAG", "Tag de Pessoa" })
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	PessoaService ps;

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public PessoaVO create(@RequestBody PessoaVO pessoaVO) {
		var entity = DozerConverter.parseObject(pessoaVO, Pessoa.class);
		var vo = DozerConverter.parseObject(ps.create(entity), PessoaVO.class);
		vo.add(linkTo(methodOn(PessoaController.class).readById(vo.getKey())).withSelfRel());
		return vo;
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PessoaVO readById(@PathVariable("id") Long id) {
		Pessoa pessoa = ps.readById(id);
		PessoaVO pessoaVO = new PessoaVO();
		pessoaVO.convertPessoaToPessoaVO(pessoa);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).readById(id)).withSelfRel());
		return pessoaVO;
	}

	@ApiOperation(value = "Busca todas as pessoas cadastradas.")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<PessoaVO> readAll() {
		List<PessoaVO> pessoasVO = new ArrayList<PessoaVO>();
		List<Pessoa> pessoas = ps.readAll();
		for (Pessoa aux : pessoas) {
			PessoaVO pessoaVO = new PessoaVO();
			pessoaVO.convertPessoaToPessoaVO(aux);
			pessoaVO.add(linkTo(methodOn(PessoaController.class).readById(aux.getId())).withSelfRel());
			pessoasVO.add(pessoaVO);
		}
		return pessoasVO;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		ps.deletePessoa(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public PessoaVO update(@RequestBody PessoaVO p) {
		Pessoa pessoa = new Pessoa();
		pessoa.convertPessoaVOToPessoa(p);
		Pessoa pessoaAlterada = ps.alteraPessoa(pessoa);
		p.convertPessoaToPessoaVO(pessoaAlterada);
		p.add(linkTo(methodOn(PessoaController.class).readById(p.getKey())).withSelfRel());
		return p;
	}

	@PatchMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PessoaVO disablePerson(@PathVariable("id") Long id) {
		Pessoa pessoa = ps.disablePerson(id);
		PessoaVO pessoaVO = new PessoaVO();
		pessoaVO.convertPessoaToPessoaVO(pessoa);
		pessoaVO.add(linkTo(methodOn(PessoaController.class).readById(id)).withSelfRel());
		return pessoaVO;

	}
}
