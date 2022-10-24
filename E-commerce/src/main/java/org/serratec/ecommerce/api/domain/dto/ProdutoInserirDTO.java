package org.serratec.ecommerce.api.domain.dto;

import org.serratec.ecommerce.api.domain.Categoria;
import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.repository.ProdutoRepository;

public class ProdutoInserirDTO {

	private Long id;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private String urlProduto;
	private Double valorUnitario;
	private Categoria categoria;
		
	public ProdutoInserirDTO() {
		super();
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

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	
	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ProdutoInserirDTO(Produto produto) {
		produto.setId(this.id);
		produto.setNomeProduto(this.nome);
		produto.setDescricaoProduto(this.descricao);
		produto.setQuantidadeEstoqueProduto(this.qtdEstoque);
		produto.setUrlProduto(this.urlProduto);
		produto.setValorUnitarioProduto(this.valorUnitario);
		produto.setCategoria(this.categoria);
		
	}
	
	public Produto atualizar(long id, ProdutoRepository prodRepo) {
		Produto produto = prodRepo.getReferenceById(id);
		produto.setId(this.id);
		produto.setNomeProduto(this.nome);
		produto.setDescricaoProduto(this.descricao);
		produto.setQuantidadeEstoqueProduto(this.qtdEstoque);
		produto.setUrlProduto(this.urlProduto);
		produto.setValorUnitarioProduto(this.valorUnitario);
		produto.setCategoria(this.categoria);
		
		return produto;
	}
	
}
