package com.hr.apirest2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hr.apirest2.utils.Constantes;

@Configuration
public class Configuracion implements WebMvcConfigurer {

  // para configurar una carpeta de archivos debes configurar un apache para que
  // este comparta dichas imagenes, esto tambien puedes usuarlo para compartir
  // -todos los archivos de la carpeta static.
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/upload/**").addResourceLocations("file: " + Constantes.RUTA_UPLOAD);
  }
}
