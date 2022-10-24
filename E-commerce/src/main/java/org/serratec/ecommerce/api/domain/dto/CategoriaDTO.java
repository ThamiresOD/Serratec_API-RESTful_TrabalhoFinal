package org.serratec.ecommerce.api.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.ecommerce.api.domain.Categoria;

public class CategoriaDTO {

	private Long idCategoria;
	private String nome;
	private String descricao;
	
	public CategoriaDTO() {

	}
	public CategoriaDTO(Categoria cat) {
		this.idCategoria = cat.getIdCategoria();
		this.nome = cat.getNome();
		this.descricao = cat.getDescricao();
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

	public static List<CategoriaDTO> converter(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
	}
}
