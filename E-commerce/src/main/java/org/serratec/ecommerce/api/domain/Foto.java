package org.serratec.ecommerce.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id da foto")
	@Column(name = "fot_cd_id")
	private Long id;
	
	@NotNull
	@ApiModelProperty(value = "Imagem do produto")
	@Column(name = "fot_dados", nullable = false)
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] dados;
	
	@NotBlank(message = "Preencha o tipo da foto")
	@ApiModelProperty(value = "Tipo da foto")
	@Column(name = "fot_tx_tipo", length = 30, nullable = false)
	private String tipo;
	
	@NotBlank(message = "Preencha o nome da foto")
	@ApiModelProperty(value = "Nome da foto")
	@Column(name = "fot_tx_nome", length = 30, nullable = false, unique = true)
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "prd_cd_id")
	private Produto produto;

	public Foto() {
	}

	public Foto(Long id, byte[] dados, String tipo, String nome, Produto produto) {
		super();
		this.id = id;
		this.dados = dados;
		this.tipo = tipo;
		this.nome = nome;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
