package org.serratec.ecommerce.api.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.ecommerce.api.domain.Categoria;

public class CategoriaDTO {

	private Long id;
	private String nome;
	private String descricao;
	
	public CategoriaDTO() {

	}
	public CategoriaDTO(Categoria cat) {
		this.id = cat.getId();
		this.nome = cat.getNome();
		this.descricao = cat.getDescricao();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static List<CategoriaDTO> converter(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
	}
}
