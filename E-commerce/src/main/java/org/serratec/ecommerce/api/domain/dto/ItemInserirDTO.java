package org.serratec.ecommerce.api.domain.dto;

import org.serratec.ecommerce.api.domain.Produto;

public class ItemInserirDTO {
	private Integer quantidade;
	private Double percentualDesconto;
	private Produto produto;

	public ItemInserirDTO() {
		super();
	}

	public ItemInserirDTO(Integer quantidade, Double percentualDesconto, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.percentualDesconto = percentualDesconto;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
