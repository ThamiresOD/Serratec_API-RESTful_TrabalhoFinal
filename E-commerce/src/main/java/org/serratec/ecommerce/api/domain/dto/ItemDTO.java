package org.serratec.ecommerce.api.domain.dto;

import org.serratec.ecommerce.api.domain.ItemPedido;
import org.serratec.ecommerce.api.domain.Produto;

public class ItemDTO {
	Long idItem;
	Integer quantidade;
	Double precoVenda;
	Double percentualDesconto;
	Double valorBruto;
	Double valorLiquido;
	Produto produto;

	public ItemDTO(Long idItem, Integer quantidade, Double precoVenda, Double percentualDesconto, Double valorBruto,
			Double valorLiquido, Produto produto) {
		super();
		this.idItem = idItem;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.produto = produto;
	}
	
	public ItemDTO(ItemPedido itemPedido) {
		this.idItem  = itemPedido.getId();
		this.quantidade=itemPedido.getQuantidade();
		this.precoVenda=itemPedido.getPrecoVenda();
		this.percentualDesconto=itemPedido.getPercentualDesconto();
		this.valorBruto=itemPedido.getValorBruto();
		this.valorLiquido=itemPedido.getValorLiquido();
		this.produto=itemPedido.getProduto();
	}
	
	
	
	@Override
	public String toString() {
		return "\n------------------------------" + 
				"\n " + produto.getNomeProduto() + " :" +
				"\nQuantidade: " + quantidade.toString() +
				"\nValor Unitário: " + valorBruto/quantidade + 
				"\nValor Bruto: " + valorBruto + 
				"\nDesconto: " + percentualDesconto*100 + "%"+
				"\nValor Total: " + valorLiquido;
	} 

	public ItemDTO() {
		super();
	}

	
	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
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
