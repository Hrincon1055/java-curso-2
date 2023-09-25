package com.hr.apirest2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hr.apirest2.models.CategoriaModel;
import com.hr.apirest2.repositories.IcategoriaRepository;

@Service
@Primary
public class CategoriaService {
  @Autowired
  private IcategoriaRepository repositorio;

  public List<CategoriaModel> toList() {
    return (List<CategoriaModel>) this.repositorio.findAll(Sort.by("id"));
  }

  public void save(CategoriaModel categoria) {
    this.repositorio.save(categoria);
  }

  public CategoriaModel findById(Integer id) {
    Optional<CategoriaModel> optional = this.repositorio.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

  public void deleteById(Integer id) {
    this.repositorio.deleteById(id);
  }
}
