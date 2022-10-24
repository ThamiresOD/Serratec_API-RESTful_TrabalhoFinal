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
	private String urlProduto;
	
	public ProdutoDTO(Produto produto) {
		this.idProduto = produto.getId();
		this.nomeProduto = produto.getNomeProduto();
		this.descricaoProduto = produto.getDescricaoProduto();
		this.quantidadeEstoqueProduto = produto.getQuantidadeEstoqueProduto();
		this.valorUnitarioProduto = produto.getValorUnitarioProduto();
		this.categoria = produto.getCategoria();
	}

	
	public ProdutoDTO() {
		super();
	}
	
	
	public String getUrlProduto() {
		return urlProduto;
	}


	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}


	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getQuantidadeEstoqueProduto() {
		return quantidadeEstoqueProduto;
	}

	public void setQuantidadeEstoqueProduto(Integer quantidadeEstoqueProduto) {
		this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
	}

	public LocalDate getDataCadastroProduto() {
		return dataCadastroProduto;
	}

	public void setDataCadastroProduto(LocalDate dataCadastroProduto) {
		this.dataCadastroProduto = dataCadastroProduto;
	}

	public Double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public void setValorUnitarioProduto(Double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}
}
