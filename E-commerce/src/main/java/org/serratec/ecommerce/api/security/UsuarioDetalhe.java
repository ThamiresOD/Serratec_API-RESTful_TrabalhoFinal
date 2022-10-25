package org.serratec.ecommerce.api.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.serratec.ecommerce.api.domain.Usuario;
import org.serratec.ecommerce.api.domain.UsuarioPerfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioDetalhe implements UserDetails{
	 private Usuario usuario;
	 public UsuarioDetalhe (Usuario usuario){
	 this.usuario = usuario;
	 }
	 @Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
	 List<GrantedAuthority> authorities = new ArrayList<>();
	 for(UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfis()){
	 authorities.add(new SimpleGrantedAuthority(usuarioPerfil.getId().getPerfil().getNome()));
	 }
	 return authorities;
	 }
	 @Override
	 public String getPassword() {
	 return usuario.getSenha();
	 }
	 @Override
	 public String getUsername() {
	 return usuario.getEmail();
	 }
}

