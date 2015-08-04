package com.eprogramar.sigaula.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eprogramar.sigaula.models.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {

	//select c from Cliente c join fetch c.telefones
	//@Query("select a from Aluno a join fetch a.telefones")
	//@Override
	//Iterable<Aluno> findAll();
	
	//@Query("select a from Aluno a join fetch a.telefones where a.id = ?1")
	//@Override
	//Aluno findOne(Long id);
	
}
