package org.serratec.ecommerce.api.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id do usuario")
	@Column(name = "user_cd_id")
	private Long idUsuario;

	@NotBlank(message = "Preencha o nome")
	@ApiModelProperty(value = "Nome do usuario")
	@Column(name = "user_tx_nome", length = 60, nullable = false, unique = true)
	private String nomeUsuario;

	@NotBlank(message = "Preencha o email")
	@ApiModelProperty(value = "Email do usuario")
	@Column(name = "user_tx_email", length = 60)
	private String email;

	@NotBlank(message = "Preencha a senha")
	@ApiModelProperty(value = "Senha do usuario")
	@Column(name = "user_tx_senha", length = 225)
	private String senha;

	@OneToMany(mappedBy = "id.usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();

	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, @NotBlank(message = "Preencha o nome") String nomeUsuario,
			@NotBlank(message = "Preencha o email") String email,
			@NotBlank(message = "Preencha a senha") String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public Set<UsuarioPerfil> getUsuarioPerfis() {
		return usuarioPerfis;
	}

	public void setUsuarioPerfis(Set<UsuarioPerfil> usuarioPerfis) {
		this.usuarioPerfis = usuarioPerfis;
	}

}
