package com.eprogramar.sigaula.controllers;

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

import com.eprogramar.sigaula.models.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	private List<Aluno> alunos = new ArrayList<Aluno>();
	
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
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("module_include", "aluno/aluno-list.jsp");
		mv.addObject("moduleDescription", "Cadastro de Alunos");
		mv.addObject("module_url_add", "/sigaula/aluno/add");
		mv.addObject("module_caption_add", "Cadastrar novo Aluno");
		mv.addObject("list", this.alunos);
		return mv;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public @ResponseBody ResponseEntity<String> save(@RequestBody Aluno aluno){
		try {
			this.alunos.add(aluno);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(aluno), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
