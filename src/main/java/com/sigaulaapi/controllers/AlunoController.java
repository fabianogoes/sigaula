package com.sigaulaapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sigaulaapii.models.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController extends BaseController {

	private List<Aluno> alunos = new ArrayList<Aluno>();
	private Long id = 1L;
	
	public AlunoController() {
		this.alunos.add(new Aluno(1L, "Fabiano", "fabiano@gmail.com"));
		this.alunos.add(new Aluno(2L, "Dulci", "dulci@gmail.com"));
		this.alunos.add(new Aluno(2L, "Leticia", "leticia@gmail.com"));
		this.alunos.add(new Aluno(2L, "Davi", "davi@gmail.com"));
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("module_include", "aluno/aluno-detail.jsp");
		mv.addObject("moduleDescription", "Cadastro de Alunos");
		return mv;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody ResponseEntity<String> list(){
		System.out.println( "list()..."  );
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.alunos), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public @ResponseBody ResponseEntity<String> save(@RequestBody Aluno aluno){
		try {
			aluno.setId( id++ );
			System.out.println( "save( "+aluno+" )" );
			this.alunos.add(aluno);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(this.alunos), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
