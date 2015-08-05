package com.eprogramar.sigaula.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eprogramar.sigaula.models.Pessoa;
import com.eprogramar.sigaula.models.PessoaTipo;
import com.eprogramar.sigaula.models.Telefone;
import com.eprogramar.sigaula.repositories.PessoaRepository;
import com.eprogramar.sigaula.repositories.TelefoneRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@RequestMapping("pageList")
	public String pageList(){
		return "pessoa/pessoa-list";
	}

	@RequestMapping("/pageForm")
	public String pageForm(){
		return "pessoa/pessoa-detail";
	}
	
	@RequestMapping(value="/tipo/{tipo}", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> findByTipo(@PathVariable("tipo") PessoaTipo tipo){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.pessoaRepository.findByTipo(tipo)), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json; charset=utf-8", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> save(@RequestBody Pessoa pessoa){
		try {
			this.pessoaRepository.save( pessoa );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.pessoaRepository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/{id}", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> get(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString( this.pessoaRepository.findOne( id ) ), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/{id}/delete", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable("id") Long id){
		try {
			this.pessoaRepository.delete( id );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.pessoaRepository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/telefone", method=RequestMethod.POST, consumes="application/json; charset=utf-8", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> telefone(@RequestBody Telefone telefone){
		try {
			this.telefoneRepository.save( telefone );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.pessoaRepository.findOne(telefone.getPessoa().getId())), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
