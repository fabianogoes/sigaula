package com.eprogramar.sigaula.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eprogramar.sigaula.repositories.AlunoRepository;
import com.eprogramar.sigaula.repositories.ProfessorRepository;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() {
		logger.info("root()...");
		return "home";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		logger.info("home()...");
		
//		Aluno aluno = new Aluno();
//		aluno.setCpfcnpj("123");
//		aluno.setDataNascimento( Calendar.getInstance() );
//		aluno.setEmail("aluno@fabiano.com");
//		aluno.setNome("Aluno");
//		this.alunoRepository.save(aluno);
//		System.out.println( "Aluno Saved = "+aluno );
//		
//		Professor professor = new Professor();
//		professor.setCpfcnpj("123");
//		professor.setDataNascimento( Calendar.getInstance() );
//		professor.setEmail("professor@fabiano.com");
//		professor.setNome("Professor");
//		this.professorRepository.save(professor);
//		System.out.println( "Professor Saved = "+professor );
		
		return "core/home-description";
	}
	
	@RequestMapping("/about")
	public String sobre() {
		logger.info("sobre()...");
		return "core/sobre";
	}
	
}
