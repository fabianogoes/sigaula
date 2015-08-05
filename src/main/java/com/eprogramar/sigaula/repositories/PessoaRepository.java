package com.eprogramar.sigaula.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eprogramar.sigaula.models.Pessoa;
import com.eprogramar.sigaula.models.PessoaTipo;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	List<Pessoa> findByTipo( PessoaTipo tipo );
}
