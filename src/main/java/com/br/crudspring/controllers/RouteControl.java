package com.br.crudspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.crudspring.models.Person;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * RouteControl
 */
@RestController
public class RouteControl {

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