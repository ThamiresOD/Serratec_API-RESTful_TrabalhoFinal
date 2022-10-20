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

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "ID do endereco")
	@Column(name = "idEndereco")
	private Long id;
	
	@NotBlank(message = "Preencha o CEP")
	@ApiModelProperty(value = "CEP do endereço")
	@Column(name = "cep", length = 8, nullable = false)
	private String cep;
	
	@NotBlank(message = "Preencha a rua")
	@ApiModelProperty(value = "Rua do endereço")
	@Column(name = "rua", length = 80, nullable = false)
	private String rua;
	
	@NotBlank(message = "Preencha o bairro")
	@ApiModelProperty(value = "Bairro do endereço")
	@Column(name = "bairro", length = 50, nullable = false)
	private String bairro;	
	
	@NotBlank(message = "Preencha a cidade")
	@ApiModelProperty(value = "Cidade do endereço")
	@Column(name = "cidade", length = 80, nullable = false)
	private String cidade;
	
	@NotBlank(message = "Preencha o numero")
	@ApiModelProperty(value = "Numero do endereço")
	@Column(name = "numero", length = 20, nullable = false)
	private String numero;
	
	@ApiModelProperty(value = "Complemento do endereço")
	@Column(name = "complemento", length = 80, nullable = true)
	private String complemento;
	
	@NotBlank(message = "Preencha a UF")
	@ApiModelProperty(value = "UF do endereço")
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;

	public Endereco() {
		super();
	}

	public Endereco(Long id, @NotNull String cep, @NotNull String rua, @NotNull String bairro, @NotNull String cidade,
			@NotNull String numero, String complemento, @NotNull String uf) {
		super();
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
