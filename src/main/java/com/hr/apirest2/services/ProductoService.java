package com.hr.apirest2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hr.apirest2.models.ProductoModel;
import com.hr.apirest2.repositories.IProductoRepository;

@Service
@Primary
public class ProductoService {
  @Autowired
  private IProductoRepository repositorio;

  public List<ProductoModel> toList() {
    return (List<ProductoModel>) this.repositorio.findAll(Sort.by("id"));
  }

  public void save(ProductoModel product) {
    this.repositorio.save(product);
  }

  public ProductoModel findById(Integer id) {
    Optional<ProductoModel> optional = this.repositorio.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

  public void deleteById(Integer id) {
    this.repositorio.deleteById(id);
  }
}
