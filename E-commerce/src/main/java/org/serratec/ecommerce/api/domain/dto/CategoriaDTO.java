package org.serratec.ecommerce.api.domain.dto;

import org.serratec.ecommerce.api.domain.Categoria;
import org.springframework.data.domain.Page;

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

	public static Page<CategoriaDTO> converter(Page<Categoria> categorias) {
		return categorias.map(CategoriaDTO::new);
	}
}
