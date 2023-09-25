package com.hr.apirest2.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.apirest2.models.ApiModel;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {

  @GetMapping("/metodo")
  public String metodo_get() {
    return "GET";
  }

  @GetMapping("/metodo/{id}")
  public String metodo_get_parametro(@PathVariable("id") String id) {
    return "GET " + id;
  }

  @PostMapping("/metodo")
  public String metodo_post() {
    return "POST";
  }

  @PostMapping("/metodo-json")
  public ApiModel metodo_post_json(@RequestBody ApiModel ejemploModel) {
    return ejemploModel;
  }

  @PutMapping("/metodo")
  public String metodo_put() {
    return "PUT";
  }

  @DeleteMapping("/metodo")
  public String metodo_delete() {
    return "DELETE";
  }
}
