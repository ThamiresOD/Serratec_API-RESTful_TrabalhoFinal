package org.serratec.ecommerce.api.security;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.serratec.ecommerce.api.security.Perfil;
import org.serratec.ecommerce.api.security.Usuario;
import org.serratec.ecommerce.api.security.UsuarioPerfil;

import io.swagger.annotations.ApiModelProperty;


public class UsuarioDTO {

	@ApiModelProperty(value="Identificador único do usuário")
	private Long id;

	@NotBlank
	@ApiModelProperty(value="Nome do usuário")
	private String nome;

	@NotBlank
	@ApiModelProperty(value="Email do usuário")
	private String email;
	
	private Set<Perfil> perfis;

	public UsuarioDTO() {

	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.perfis = new HashSet<>();
		for (UsuarioPerfil usuarioPerfil : usuario.getUsuarioPerfis()) {
			this.perfis.add(usuarioPerfil.getId().getPerfil());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

}
