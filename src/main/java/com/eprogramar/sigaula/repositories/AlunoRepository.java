package com.eprogramar.sigaula.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eprogramar.sigaula.models.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
}
