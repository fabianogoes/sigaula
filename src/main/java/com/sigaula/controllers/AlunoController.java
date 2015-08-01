package com.sigaula.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sigaula.daos.AlunoDAO;
import com.sigaula.models.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoDAO dao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model){
		return "aluno/aluno-list";
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String add(){
		return "aluno/aluno-detail";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody ResponseEntity<String> list(){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.dao.list()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public @ResponseBody ResponseEntity<String> save(@RequestBody Aluno aluno){
		try {
			System.out.println( "save( "+aluno+ ")" );
			this.dao.save( aluno );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.dao.list()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody ResponseEntity<String> edit(@PathVariable("id") Long id){
		try {
			Aluno aluno = this.dao.find( id );
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(aluno), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody ResponseEntity<String> remove(@PathVariable("id") Long id){
		try {
			this.dao.remove(id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.dao.list()), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
