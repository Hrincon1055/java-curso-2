package com.hr.apirest2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hr.apirest2.models.CategoriaModel;
import com.hr.apirest2.models.ProductoModel;
import com.hr.apirest2.services.CategoriaService;
import com.hr.apirest2.services.ProductoService;
import com.hr.apirest2.utils.Constantes;
import com.hr.apirest2.utils.Utilidades;

@RestController
@RequestMapping("/api/v1")
public class BdController {
  @Autowired
  private CategoriaService categoriaService;
  @Autowired
  private ProductoService productoService;

  @GetMapping("/categorias")
  public ResponseEntity<Object> toListCategoria() {
    return Utilidades.<List<CategoriaModel>>generateResponse(HttpStatus.OK, "Mensaje Personalizado",
        this.categoriaService.toList());
  }

  @GetMapping("/categorias/{id}")
  public ResponseEntity<Object> findByIdCategoria(@PathVariable("id") Integer id) {
    CategoriaModel categoria = this.categoriaService.findById(id);
    if (categoria != null) {
      return Utilidades.<CategoriaModel>generateResponse(HttpStatus.OK, "Categoria encontrada", categoria);
    }
    return Utilidades.<CategoriaModel>generateResponse(HttpStatus.NOT_FOUND, "Categoria no encontrada",
        null);
  }

  @PostMapping("/categorias")
  public ResponseEntity<Object> saveCategoria(@RequestBody CategoriaModel categoria) {
    categoria.setSlug(Utilidades.getSlug(categoria.getNombre()));
    this.categoriaService.save(categoria);
    return Utilidades.generateResponse(HttpStatus.CREATED, "Categoria guardada Correctamente",
        null);
  }

  @PutMapping("/categorias/{id}")
  public ResponseEntity<Object> updateCategoria(@RequestBody CategoriaModel categoria, @PathVariable("id") Integer id) {
    CategoriaModel newCategoria = this.categoriaService.findById(id);
    try {
      if (newCategoria != null) {
        newCategoria.setNombre(categoria.getNombre());
        newCategoria.setSlug(Utilidades.getSlug(categoria.getNombre()));
        this.categoriaService.save(newCategoria);
        return Utilidades.<CategoriaModel>generateResponse(HttpStatus.OK, "Categoria actualizada correctamente",
            newCategoria);
      }
      return Utilidades.generateResponse(HttpStatus.NOT_FOUND, "Categoria no encontrada",
          null);
    } catch (Exception e) {
      System.out.println(e);
      String mensajeError = String.format("No se pudo eliminar la categoria %d intente mas tarde", id);
      return Utilidades.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, mensajeError, null);
    }

  }

  @DeleteMapping("/categorias/{id}")
  public ResponseEntity<Object> deleteCategoria(@PathVariable("id") Integer id) {
    CategoriaModel categoria = this.categoriaService.findById(id);
    try {
      if (categoria != null) {
        this.categoriaService.deleteById(id);
        String mensaje = String.format("Categoria eliminada %d", id);
        return Utilidades.generateResponse(HttpStatus.OK, mensaje, null);
      }
      return Utilidades.generateResponse(HttpStatus.NOT_FOUND, "Categoria no encontrada", null);
    } catch (Exception e) {
      System.out.println(e);
      String mensajeError = String.format("No se pudo eliminar la categoria %d intente mas tarde", id);
      return Utilidades.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, mensajeError, null);
    }
  }

  // ######################Productos#################### //
  @GetMapping("/productos")
  public ResponseEntity<Object> toListProducts() {
    return Utilidades.<List<ProductoModel>>generateResponse(HttpStatus.OK, "Mensaje Personalizado",
        this.productoService.toList());
  }

  @PostMapping("/productos")
  public ResponseEntity<Object> saveProducts(ProductoModel product, @RequestParam("file") MultipartFile file) {
    HttpStatus estatus = HttpStatus.OK;
    String mesage = "";
    if (!file.isEmpty()) {
      String nombreImagen = Utilidades.guardarArchivo(file, Constantes.RUTA_UPLOAD);
      if (nombreImagen == null) {
        estatus = HttpStatus.BAD_REQUEST;
        mesage = "La foto enviada no es valida";
      } else {
        if (nombreImagen != null) {
          product.setFoto(nombreImagen);
          product.setSlug(Utilidades.getSlug(product.getNombre()));
          this.productoService.save(product);
          estatus = HttpStatus.OK;
          mesage = "Se creo el registro correctamente";
        }
      }
    } else {
      estatus = HttpStatus.BAD_REQUEST;
      mesage = "La foto enviada no es valida";
    }
    return Utilidades.generateResponse(estatus, mesage, null);
  }
}
