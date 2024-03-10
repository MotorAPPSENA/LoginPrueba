package com.motor.app.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.motor.app.login.model.Usuario;

/*
 * Repository o DAO, objeto que se crea para el acceso a datos
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  /*
   * Consulta a la base de datos como filtro el username
   */
  Usuario findByUsername(String username);
}
