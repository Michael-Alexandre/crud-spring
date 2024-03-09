package com.br.crudspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.crudspring.models.Person;
import com.br.crudspring.repository.Repointerface;
import com.br.crudspring.servico.Servico;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




/**
 * RouteControl
 */
@RestController
public class RouteControl {

  @Autowired
  private Repointerface action;

  @Autowired
  private Servico servico;

  @PostMapping("/api")
  public ResponseEntity<?> inputPerson(@RequestBody Person obj){
    return servico.inputPerson(obj);
  }

  @GetMapping("/api")
  public ResponseEntity<?> selectPersons(){
    return servico.selectPerson();
  }

  @DeleteMapping("/api/{codigo}")
  public ResponseEntity<?> removePerson(@PathVariable int codigo){
    return servico.removePerson(codigo);
  }

  @GetMapping("/api/{codigo}")
  public ResponseEntity<?>  selectByCodigo(@PathVariable int codigo){
    return servico.selectByCodigo(codigo);
  }

  @PutMapping("/api")
  public ResponseEntity<?> updatePerson(@RequestBody Person obj) {

    return servico.updatePerson(obj);
  }


  @GetMapping("/api/counter")
  public long countPerson(){
    return action.count();
  }

  @GetMapping("/api/orderbySetor")
  public List<Person> orderSetor(){
    return action.findByOrderBySetorDesc();
  }

  @GetMapping("/api/find/{termo}")
  public List<Person> findSetor(@PathVariable String termo){
    return action.findBySetorContaining(termo);
  }

  @GetMapping("/api/qtdSector")
  public int numSectors(){
    return action.sectorQtd();
  }

  @GetMapping("/{name}")
  public String msg(@PathVariable String name){
    return "Esteja bem " + name;
  }
  
  @GetMapping("/")
  public String msg(){
    return "Esteja bem ";
  }

  @PostMapping("/person")
  public Person person(@RequestBody Person p){
    return p;
  }
}