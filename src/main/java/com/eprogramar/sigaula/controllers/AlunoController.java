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

import com.eprogramar.sigaula.models.Aluno;
import com.eprogramar.sigaula.models.Telefone;
import com.eprogramar.sigaula.repositories.AlunoRepository;
import com.eprogramar.sigaula.repositories.TelefoneRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@RequestMapping("pageList")
	public String pageList(){
		return "aluno/aluno-list";
	}

	@RequestMapping("/pageForm")
	public String pageForm(){
		return "aluno/aluno-detail";
	}
	
	@RequestMapping(produces="application/json")
	public @ResponseBody ResponseEntity<String> listAll(){
		try {
			
			//Aluno aluno = this.repository.findOne(1L);
			//Telefone telefone = new Telefone(null, "(11)98765-1234", aluno);
			//this.telefoneRepository.save(telefone);
			
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.repository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public @ResponseBody ResponseEntity<String> save(@RequestBody Aluno aluno){
		try {
			System.out.println( "save( "+aluno+ ")" );
			this.repository.save( aluno );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.repository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/{id}", produces="application/json")
	public @ResponseBody ResponseEntity<String> get(@PathVariable("id") Long id){
		try {
			Aluno aluno = this.repository.findOne( id );
			
			System.out.println( ">>>>>>>>>>>>> Telefones <<<<<<<<<<<<<<<<<" );
			for (Telefone telefone : aluno.getTelefones()) {
				System.out.println( telefone );
			}
			
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(aluno), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/{id}/delete", produces="application/json")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable("id") Long id){
		try {
			this.repository.delete( id );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.repository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/telefone", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public @ResponseBody ResponseEntity<String> telefone(@RequestBody Telefone telefone){
		try {
			System.out.println( "telefone( "+telefone+ ")" );
			this.telefoneRepository.save( telefone );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.repository.findOne(telefone.getAluno().getId())), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
