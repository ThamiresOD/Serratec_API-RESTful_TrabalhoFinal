package org.serratec.ecommerce.api.security;

import org.serratec.ecommerce.api.security.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long> {

}
