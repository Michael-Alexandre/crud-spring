package com.br.crudspring.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.crudspring.models.Mensagem;
import com.br.crudspring.models.Person;
import com.br.crudspring.repository.Repointerface;

@Service
public class Servico {
  
  @Autowired
  private Mensagem mensagem;

  @Autowired
  private Repointerface action;

  //metodo para cadastro pessoas
  public ResponseEntity<?> inputPerson(Person objPerson){

    if (objPerson.getNome().equals("")){
      mensagem.setMensagem("Nome precisa ser preenchido");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }else if(objPerson.getSetor().equals("")) {
      mensagem.setMensagem("Informe setor");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }else{
      return new ResponseEntity<>(action.save(objPerson), HttpStatus.CREATED);
    }
  }

  //metodo lista pessoas
  public ResponseEntity<?> selectPerson(){
    return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
  }

  //metodo busca por codigo
  public ResponseEntity<?> selectByCodigo(int codigo){
    if(action.countByCodigo(codigo) == 0){
      mensagem.setMensagem("codigo não encontrado");
      return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
    }else{
      return new ResponseEntity<>(action.findByCodigo(codigo), HttpStatus.OK);
    }
  }

  //metodo para editar dados - update
  public ResponseEntity<?> updatePerson(Person obj){

    if(action.countByCodigo(obj.getCodigo()) == 0){
      mensagem.setMensagem("codigo informado não existe");
      return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
    }else if(obj.getNome().equals("")){
      mensagem.setMensagem("Nome não pode ser vazio");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }else if(obj.getSetor().equals("")){
      mensagem.setMensagem("Setor não pode ser vazio");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }else{
      return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
    }
  }


}