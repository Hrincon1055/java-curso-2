package com.hr.apirest2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.apirest2.models.UsuarioModel;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
  public UsuarioModel findByCorreo(String correo);
}
