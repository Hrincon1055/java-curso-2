package com.hr.apirest2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductoModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nombre;
  private String slug;
  private String descripcion;
  private Integer precio;
  private String foto;
  @OneToOne
  @JoinColumn(name = "categoria_id")
  private CategoriaModel categoriaId;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getSlug() {
    return this.slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Integer getPrecio() {
    return this.precio;
  }

  public void setPrecio(Integer precio) {
    this.precio = precio;
  }

  public String getFoto() {
    return this.foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public CategoriaModel getCategoriaId() {
    return this.categoriaId;
  }

  public void setCategoriaId(CategoriaModel categoriaId) {
    this.categoriaId = categoriaId;
  }

}
