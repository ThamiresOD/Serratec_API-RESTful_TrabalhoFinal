package org.serratec.ecommerce.api.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id da categoria")
	@Column(name = "cat_cd_id")
	private Long idCategoria;
	
	@NotBlank(message = "Preencha o nome")
	@ApiModelProperty(value = "Nome da categoria")
	@Column(name = "cat_tx_nome", length = 30, nullable = false, unique = true)
	private String nome;
	
	@NotBlank(message = "Preencha a descricao")
	@ApiModelProperty(value = "Descricao da categoria")
	@Column(name = "cat_tx_descricao", length = 200)
	private String descricao;
	
	public Categoria() {
		super();
	}

	public Categoria(Long idCategoria, @Size(max = 30) @NotNull String nome, @Size(max = 200) @NotNull String descricao) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idCategoria);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(idCategoria, other.idCategoria);
	}
	
	
	
}
