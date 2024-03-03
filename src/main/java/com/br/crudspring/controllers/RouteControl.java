package com.br.crudspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.crudspring.models.Person;
import com.br.crudspring.repository.Repointerface;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




/**
 * RouteControl
 */
@RestController
public class RouteControl {

  @Autowired
  private Repointerface action;

  @PostMapping("/api")
  public Person createPerson(@RequestBody Person obj){
    return action.save(obj);
  }

  @GetMapping("/api")
  public List<Person> selectPersons(){
    return action.findAll();
  }

  @GetMapping("/api/{code}")
  public Person selectbyCode(@PathVariable int code){
    return action.findByCodigo(code);
  }

  @PutMapping("/api")
  public Person updatePerson(@RequestBody Person obj) {

    return action.save(obj);
  }

  @DeleteMapping("/api/{code}")
  public void removePerson(@PathVariable int code){
    Person obj = selectbyCode(code);
    action.delete(obj);
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