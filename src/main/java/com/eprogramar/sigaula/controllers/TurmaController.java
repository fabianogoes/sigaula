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
import com.eprogramar.sigaula.models.Turma;
import com.eprogramar.sigaula.repositories.TelefoneRepository;
import com.eprogramar.sigaula.repositories.TurmaRepository;

@Controller
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@RequestMapping("pageList")
	public String pageList(){
		return "turma/turma-list";
	}

	@RequestMapping("/pageForm")
	public String pageForm(){
		return "turma/turma-detail";
	}
	
	@RequestMapping(produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> findAll(){
		try {
			Iterable<Turma> turmas = this.turmaRepository.findAll();
			for (Turma turma : turmas) {
				System.out.println( "**************************************" );
				System.out.println( turma.getCurso().getNome() );
				System.out.println( "**************************************" );
				for (Aluno aluno : turma.getAlunos()) {
					System.out.println( aluno );
				}
			}
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(turmas), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json; charset=utf-8", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> save(@RequestBody Turma turma){
		try {
			System.out.println( "Turma Save = "+turma );
			this.turmaRepository.save( turma );
			List<Turma> turmas = (List<Turma>) this.turmaRepository.findAll();
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(turmas), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/{id}", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> get(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString( this.turmaRepository.findOne( id ) ), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/{id}/delete", produces="application/json; charset=utf-8")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable("id") Long id){
		try {
			this.turmaRepository.delete( id );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.turmaRepository.findAll()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
