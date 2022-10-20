package org.serratec.ecommerce.api.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id do produto")
	@Column(name = "prd_cd_id")
	private Long id;
	
	@NotBlank(message = "Preencha o nome")
	@ApiModelProperty(value = "Nome do produto")
	@Column(name = "prd_tx_nome", length = 30, nullable = false, unique = true)
	private String nomeProduto;
	
	@ApiModelProperty(value = "Descricao do produto")
	@Column(name = "prd_tx_descricao", length = 200)
	private String descricaoProduto;
	
	@ApiModelProperty(value = "Quantidade em estoque do produto")
	@Column(name = "prd_int_quantidade_estoque", nullable = true)
	private Integer quantidadeEstoqueProduto;
	
	@ApiModelProperty(value = "Data de cadastro do produto")
	@Column(name = "prd_dt_data_cadastro")
	private LocalDate dataCadastroProduto;
	
	@NotNull
	@ApiModelProperty(value = "Valor unitario do produto")
	@Column(name = "prd_nm_valor_unitario", nullable = false)
	private Double valorUnitarioProduto;
	
	@NotNull
	@ApiModelProperty(value = "Imagem do produto")
	@Column(name = "imagem_produto", nullable = false)
	private byte[] imagemProduto;
	
	@ManyToOne
	@JoinColumn(name = "cat_cd_id", nullable = false)
	private Categoria categoria;

	public Produto() {
		super();
	}

	public Produto(Long id, @NotBlank(message = "Preencha o nome") String nomeProduto, String descricaoProduto,
			Integer quantidadeEstoqueProduto, LocalDate dataCadastroProduto, @NotNull Double valorUnitarioProduto,
			@NotNull byte[] imagemProduto, Categoria categoria) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
		this.dataCadastroProduto = dataCadastroProduto;
		this.valorUnitarioProduto = valorUnitarioProduto;
		this.imagemProduto = imagemProduto;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public byte[] getImagemProduto() {
		return imagemProduto;
	}

	public void setImagemProduto(byte[] imagemProduto) {
		this.imagemProduto = imagemProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
}
