package com.eprogramar.sigaula.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eprogramar.sigaula.models.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
