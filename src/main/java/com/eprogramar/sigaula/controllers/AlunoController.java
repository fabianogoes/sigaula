package com.eprogramar.sigaula.controllers;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eprogramar.sigaula.models.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("module_include", "aluno/aluno-detail.jsp");
		mv.addObject("moduleDescription", "Cadastro de Alunos");
		mv.addObject("model", new Aluno());
		return mv;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("module_include", "aluno/aluno-list.jsp");
		mv.addObject("moduleDescription", "Cadastro de Alunos");
		mv.addObject("module_url_add", "/sigaula/aluno/add");
		mv.addObject("module_caption_add", "Cadastrar novo Aluno");
		mv.addObject("list", Arrays.asList( new Aluno(1L, "Fabiano", "fabiano@gmail.com"),
											new Aluno(2L, "Dulci", "dulci@gmail.com"),
											new Aluno(2L, "Leticia", "leticia@gmail.com"),
											new Aluno(2L, "Davi", "davi@gmail.com")));
		return mv;
	}
	
}
