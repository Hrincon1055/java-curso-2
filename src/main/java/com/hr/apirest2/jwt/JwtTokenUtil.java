package com.hr.apirest2.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.hr.apirest2.models.UsuarioModel;
import com.hr.apirest2.utils.Constantes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil {
  private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;

  public boolean validateAccessToken(String token) {
    try {
      Jwts.parser().setSigningKey(Constantes.FIRMA).parseClaimsJws(token);
      return true;
    } catch (ExpiredJwtException ex) {
      System.out.println("JWT expirado. " + ex.getMessage());
    } catch (IllegalArgumentException ex) {
      System.out.println("Token es null. " + ex.getMessage());
    } catch (MalformedJwtException ex) {
      System.out.println("JWT es invalido. " + ex.getMessage());
    } catch (UnsupportedJwtException ex) {
      System.out.println("JWT no soportado. " + ex.getMessage());
    } catch (SignatureException ex) {
      System.out.println("Validacion de firma errone. " + ex.getMessage());
    }
    return false;
  }

  public String generarToken(UsuarioModel usuario) {
    String token = Jwts.builder()
        .setSubject(String.format("%s,%s", usuario.getId(), usuario.getCorreo()))
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
        .signWith(SignatureAlgorithm.HS512, Constantes.FIRMA)
        .compact();

    return token;
  }

  public String getSubject(String token) {
    return parseClaims(token).getSubject();
  }

  private Claims parseClaims(String token) {
    return Jwts.parser().setSigningKey(Constantes.FIRMA).parseClaimsJws(token).getBody();
  }
}
