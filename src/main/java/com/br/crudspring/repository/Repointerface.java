package com.br.crudspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.crudspring.models.Person;

@Repository
public interface Repointerface extends CrudRepository<Person, Integer>{
  
}
