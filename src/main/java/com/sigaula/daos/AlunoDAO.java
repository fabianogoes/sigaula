package com.sigaula.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sigaula.models.Aluno;

@Repository
public class AlunoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Aluno> list(){
		return this.em.createQuery("from Aluno", Aluno.class).getResultList();
	}

	@Transactional
	public Aluno save(Aluno aluno) {
		if( aluno != null && aluno.getId() != null ){
			this.em.merge( aluno );
		}else{
			this.em.persist( aluno );
		}
		return aluno;
	}
	
	@Transactional
	public void remove(Long id){
		Aluno aluno = this.find(id);
		this.em.remove(aluno);
	}

	public Aluno find(Long id) {
		return this.em.find(Aluno.class, id);
	}
	
}
