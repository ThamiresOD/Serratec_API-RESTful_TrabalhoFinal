package org.serratec.ecommerce.api.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id do cliente")
	@Column(name = "cli_cd_id")
	private Long id;
	
	@NotBlank(message = "Preencha o nome completo")
	@ApiModelProperty(value = "Nome completo do cliente")
	@Column(name = "cli_tx_nome_completo", length = 50, nullable = false)
	private String nomeCompleto;
	
	@NotBlank(message = "Preencha o email")
	@ApiModelProperty(value = "Email do cliente")
	@Column(name = "cli_tx_email", length = 80, nullable = false, unique = true)
	private String email;
	
	@CPF
	@NotBlank(message = "Preencha o cpf")
	@ApiModelProperty(value = "CPF do cliente")
	@Column(name = "cli_tx_cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@NotBlank(message = "Preencha o telefone")
	@ApiModelProperty(value = "Telefone do cliente")
	@Column(name = "cli_tx_telefone", length = 40, nullable = false)
	private String telefone;
	
	@NotNull
	@ApiModelProperty(value = "Data de nascimento do cliente")
	@Column(name = "cli_dt_data_nascimento")
	private LocalDate dataNascimento;
	
	@OneToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL) 
	@JoinColumn(name = "end_cd_id", nullable = false)
	private Endereco endereco;

	public Cliente() {
		super();
	}

	public Cliente(Long id, @NotNull String nomeCompleto, @NotNull String email, @NotNull String cpf,
			@NotNull String telefone, @NotNull LocalDate dataNascimento, Endereco endereco) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
