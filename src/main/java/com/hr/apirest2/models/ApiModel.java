package com.hr.apirest2.models;

public class ApiModel {
  private String nombre;
  private String correo;
  private Integer precio;
  private String descripcion;

  public ApiModel() {
  }

  public ApiModel(String nombre, String correo, Integer precio, String descripcion) {
    this.nombre = nombre;
    this.correo = correo;
    this.precio = precio;
    this.descripcion = descripcion;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return this.correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public Integer getPrecio() {
    return this.precio;
  }

  public void setPrecio(Integer precio) {
    this.precio = precio;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "{" +
        " nombre='" + getNombre() + "'" +
        ", correo='" + getCorreo() + "'" +
        ", precio='" + getPrecio() + "'" +
        ", descripcion='" + getDescripcion() + "'" +
        "}";
  }

}
