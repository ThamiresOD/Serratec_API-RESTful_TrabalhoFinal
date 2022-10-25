package org.serratec.ecommerce.api.domain.dto;

import org.serratec.ecommerce.api.domain.Categoria;
import org.serratec.ecommerce.api.repository.CategoriaRepository;

public class CategoriaInserirDTO {
	private String nomeCategoria;
	private String descricaoCategoria;
	
	public CategoriaInserirDTO() {
		super();
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public CategoriaInserirDTO(Categoria categoria) {
		categoria.setNome(this.nomeCategoria);
		categoria.setDescricao(this.descricaoCategoria);
	}

	public Categoria atualizar(Long id, CategoriaRepository catRepo) {
		Categoria categoria = catRepo.getReferenceById(id);

		categoria.setNome(this.nomeCategoria);
		categoria.setDescricao(this.descricaoCategoria);

		return categoria;
	}
}
