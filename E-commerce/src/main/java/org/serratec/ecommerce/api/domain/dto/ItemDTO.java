package org.serratec.ecommerce.api.domain.dto;

import org.serratec.ecommerce.api.domain.ItemPedido;
import org.serratec.ecommerce.api.domain.Produto;

public class ItemDTO {
	Integer quantidade;
	Double precoVenda;
	Double percentualDesconto;
	Double valorBruto;
	Double valorLiquido;
	Produto produto;

	public ItemDTO(Integer quantidade, Double precoVenda, Double percentualDesconto, Double valorBruto,
			Double valorLiquido, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.produto = produto;
	}
	
	public ItemDTO(ItemPedido itemPedido) {
		this.quantidade=itemPedido.getQuantidade();
		this.precoVenda=itemPedido.getPrecoVenda();
		this.percentualDesconto=itemPedido.getPercentualDesconto();
		this.valorBruto=itemPedido.getValorBruto();
		this.valorLiquido=itemPedido.getValorLiquido();
		this.produto=itemPedido.getProduto();
	}

	public ItemDTO() {
		super();
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
