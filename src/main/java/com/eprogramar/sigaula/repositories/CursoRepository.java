package com.eprogramar.sigaula.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eprogramar.sigaula.models.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
}
