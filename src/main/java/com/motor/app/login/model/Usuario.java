package com.motor.app.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Entidad que representa la tabla y sus campos en la base de datos
 */
@Data // Permite contener metodos necesarios de la entidad
@Entity
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;

  private String password;

  public Usuario(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
