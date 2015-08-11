package com.eprogramar.sigaula.controllers;

import java.util.List;

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
	private AlunoRepository alunoRepository;
	
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
	
	@RequestMapping(produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> findAll(){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.alunoRepository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json; charset=utf-8", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> save(@RequestBody Aluno aluno){
		try {
			this.alunoRepository.save( aluno );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.alunoRepository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/{id}", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> get(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString( this.alunoRepository.findOne( id ) ), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/{id}/delete", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable("id") Long id){
		try {
			this.alunoRepository.delete( id );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.alunoRepository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/telefone", method=RequestMethod.POST, consumes="application/json; charset=utf-8", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> telefone(@RequestBody Telefone telefone){
		try {
			this.telefoneRepository.save( telefone );
			List<Aluno> alunos = null; // this.alunoRepository.findOne(telefone.getPessoa().getId())
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(alunos), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
