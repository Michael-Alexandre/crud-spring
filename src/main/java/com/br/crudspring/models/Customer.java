package com.br.crudspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int code;
  @NotEmpty(message = "Informe um nome")
  private String name;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  private String organization;
  public String getOrganization() {
    return organization;
  }
  public void setOrganization(String organization) {
    this.organization = organization;
  }

  @Email(message = "Informe email válido")
  private String email;
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }


}
