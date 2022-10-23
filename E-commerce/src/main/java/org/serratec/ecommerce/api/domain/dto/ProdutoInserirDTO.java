package org.serratec.ecommerce.api.domain.dto;

import org.serratec.ecommerce.api.domain.Categoria;
import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.service.ProdutoService;

public class ProdutoInserirDTO {

	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private String urlProduto;
	private Categoria categoria;
	
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public ProdutoInserirDTO(Produto produto) {
		produto.setNomeProduto(this.nome);
		produto.setDescricaoProduto(this.descricao);
		produto.setQuantidadeEstoqueProduto(this.qtdEstoque);
		produto.setCategoria(this.categoria);
		produto.setUrlProduto(this.urlProduto);
	}

	public Produto converter(ProdutoService produtoService, Produto produto) {
		Produto prod = produtoService.findById(produto);
		return new Produto();
	}

	
	
}
