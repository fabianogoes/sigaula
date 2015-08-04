package com.eprogramar.sigaula.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eprogramar.sigaula.models.Telefone;

@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Long> {

}
