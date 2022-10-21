package org.serratec.ecommerce.api.domain.dto;

import org.serratec.ecommerce.api.domain.Categoria;

public class CategoriaDTO {
	private String nome;
	private String descricao;
	
	public CategoriaDTO(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	public CategoriaDTO(Categoria cat) {
		this.nome = cat.getNome();
		this.descricao = cat.getDescricao();
	}
	public CategoriaDTO() {
		
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
	
	
}
