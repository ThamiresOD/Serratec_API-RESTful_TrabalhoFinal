package org.serratec.ecommerce.api.domain.dto;

import java.time.LocalDate;

public class ClienteInserirDTO {
	private String nomeCompleto;
	private String cpf;
	private String email;
	private String telefone;
	private LocalDate dataNascimento;
	private String cep;
	private String numero;
		
	public ClienteInserirDTO() {
		super();
	}
	
	public ClienteInserirDTO(String nomeCompleto, String cpf, String email, String telefone, LocalDate dataNascimento, String cep,
			String numero) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.numero = numero;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
