package com.hr.apirest2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.apirest2.models.CategoriaModel;

public interface IcategoriaRepository extends JpaRepository<CategoriaModel, Integer> {

}
