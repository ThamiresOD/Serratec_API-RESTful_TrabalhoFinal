package org.serratec.ecommerce.api.domain.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.serratec.ecommerce.api.domain.Categoria;
import org.serratec.ecommerce.api.domain.Produto;

public class ProdutoDTO {
	private Long idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private Integer quantidadeEstoqueProduto;
	private LocalDate dataCadastroProduto;
	private Double valorUnitarioProduto;
	private Categoria categoria;

	public ProdutoDTO(Produto produto) {
		this.idProduto = produto.getId();
		this.nomeProduto = produto.getNomeProduto();
		this.descricaoProduto = produto.getDescricaoProduto();
		this.quantidadeEstoqueProduto = produto.getQuantidadeEstoqueProduto();
		this.dataCadastroProduto = produto.getDataCadastroProduto();
		this.valorUnitarioProduto = produto.getValorUnitarioProduto();
		this.categoria = produto.getCategoria();
	}

	public ProdutoDTO() {
		super();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public Integer getQuantidadeEstoqueProduto() {
		return quantidadeEstoqueProduto;
	}

	public LocalDate getDataCadastroProduto() {
		return dataCadastroProduto;
	}

	public Double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}
}
