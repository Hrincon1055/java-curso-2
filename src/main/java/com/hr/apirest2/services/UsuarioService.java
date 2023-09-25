package com.hr.apirest2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.hr.apirest2.models.UsuarioModel;
import com.hr.apirest2.repositories.IUsuarioRepository;

@Service
@Primary
public class UsuarioService {
  @Autowired
  private IUsuarioRepository repositorio;

  public void save(UsuarioModel categoria) {
    this.repositorio.save(categoria);
  }

  public UsuarioModel findByEmail(String correo) {
    return this.repositorio.findByCorreo(correo);
  }
}
