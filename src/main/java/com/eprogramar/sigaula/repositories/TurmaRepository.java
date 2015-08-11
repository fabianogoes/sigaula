package com.eprogramar.sigaula.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eprogramar.sigaula.models.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Long> {
}
