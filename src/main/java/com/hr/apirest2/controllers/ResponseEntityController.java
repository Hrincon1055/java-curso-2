package com.hr.apirest2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.apirest2.utils.Utilidades;

@RestController
@RequestMapping("/api/v1/")
public class ResponseEntityController {
  @GetMapping("/response-entity")
  public ResponseEntity<String> metodo_get() {
    return ResponseEntity.ok("GET ENTITY");
  }

  @GetMapping("/response-entity-personalizado")
  public ResponseEntity<Object> metodo_get_personalizado() {
    return Utilidades.<String>generateResponse(HttpStatus.OK, "Mensaje Personalizado", "Hola");
  }

  @PostMapping("/response-entity")
  public ResponseEntity<String> metodo_post() {
    return ResponseEntity.ok("POST ENTITY");
  }

  @PutMapping("/response-entity")
  public ResponseEntity<String> metodo_put() {
    return ResponseEntity.ok("PUT ENTITY");
  }

  @DeleteMapping("/response-entity")
  public ResponseEntity<String> metodo_delete() {
    return ResponseEntity.ok("DELETE ENTITY");
  }
}
