package org.serratec.ecommerce.api.security;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.serratec.ecommerce.api.security.Perfil;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioInserirDTO {

	@NotBlank
	@ApiModelProperty(value="Nome do usuário")
	private String nome;

	@NotBlank
	@ApiModelProperty(value="Email do usuário")
	private String email;

	@NotBlank
	@ApiModelProperty(value="Senha do usuário")
	private String senha;

	@NotBlank
	@ApiModelProperty(value="Confirmação de senha do usuário")
	private String confirmaSenha;

	private Set<Perfil> perfis;

	public UsuarioInserirDTO() {

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

}
