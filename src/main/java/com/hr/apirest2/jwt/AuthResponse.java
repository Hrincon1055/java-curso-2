package com.hr.apirest2.jwt;

public class AuthResponse {
  private String correo;
  private String accessToken;

  public AuthResponse() {
  }

  public AuthResponse(String correo, String accessToken) {
    this.correo = correo;
    this.accessToken = accessToken;
  }

  public String getCorreo() {
    return this.correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getAccessToken() {
    return this.accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

}
