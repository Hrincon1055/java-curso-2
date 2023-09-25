package com.hr.apirest2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.apirest2.models.ProductoModel;

public interface IProductoRepository extends JpaRepository<ProductoModel, Integer> {

}
