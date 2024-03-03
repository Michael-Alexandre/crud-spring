package com.br.crudspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.crudspring.models.Person;

@Repository
public interface Repointerface extends CrudRepository<Person, Integer>{
  
  List<Person> findAll();

  Person findByCodigo(int codigo);

  List<Person> findByOrderBySetorDesc();

  List<Person> findBySetorContaining(String termo);

  @Query(value = "SELECT COUNT(DISTINCT setor) FROM person LIMIT 100", nativeQuery = true)
  int sectorQtd();
}
