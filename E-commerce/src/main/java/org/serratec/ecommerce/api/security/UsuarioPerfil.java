package org.serratec.ecommerce.api.security;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "usuario_perfil")
public class UsuarioPerfil {

	@EmbeddedId
	private UsuarioPerfilPK id = new UsuarioPerfilPK();
	@ApiModelProperty(value="Data da criação")
	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	public UsuarioPerfil() {
		
	}
	
	public UsuarioPerfil(Usuario usuario, Perfil perfil, LocalDate dataCriacao) {
		super();
		this.id.setUsuario(usuario);
		this.id.setPerfil(perfil);
		this.dataCriacao = LocalDate.now();
		this.id.getUsuario().getNome();
	}

	public UsuarioPerfilPK getId() {
		return id;
	}

	public void setId(UsuarioPerfilPK id) {
		this.id = id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioPerfil other = (UsuarioPerfil) obj;
		return Objects.equals(id, other.id);
	}

}
