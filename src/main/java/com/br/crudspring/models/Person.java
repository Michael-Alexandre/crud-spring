package com.br.crudspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
  
  //atributos
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int codigo;
  private String nome;
  private String setor;

  public int getCodigo() {
    return codigo;
  }
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }
  public String getSetor() {
    return setor;
  }
  public void setSetor(String setor) {
    this.setor = setor;
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

}
