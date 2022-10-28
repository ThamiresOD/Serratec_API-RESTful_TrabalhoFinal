package org.serratec.ecommerce.api.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.serratec.ecommerce.api.security.Usuario;
import org.serratec.ecommerce.api.security.UsuarioPerfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioDetalhe implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public UsuarioDetalhe(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfis()) {
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

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}