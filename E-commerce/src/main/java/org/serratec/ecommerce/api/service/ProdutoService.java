package org.serratec.ecommerce.api.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.domain.dto.ProdutoDTO;
import org.serratec.ecommerce.api.domain.dto.ProdutoInserirDTO;
import org.serratec.ecommerce.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository prodRepo;

	@Autowired
	private FotoService fotoService;

	public List<Produto> findAll() {
		return prodRepo.findAll();
	}

	public Produto inserir(Produto produto) {
		return prodRepo.save(produto);
	}

	public ProdutoDTO inserir(ProdutoInserirDTO produto, MultipartFile file) throws IOException {
		produto = prodRepo.save(produto);
		Produto produtoDB = new Produto(produto);
		fotoService.inserir(produtoDB, file);
		return adicionarImagemUri(produtoDB);
	}

	public List<ProdutoDTO> listar() {
		List<Produto> produtos = prodRepo.findAll();
		List<ProdutoDTO> dtos = new ArrayList<>();
		for (Produto produto : produtos) {
			ProdutoDTO dto = adicionarImagemUri(produto);
			dtos.add(dto);
		}
		return dtos;
	}

	public ProdutoDTO buscar(Long id) {
		Optional<Produto> produto = prodRepo.findById(id);
		return adicionarImagemUri(produto.get());
	}
	
	public ProdutoDTO adicionarImagemUri(Produto produto) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/produtos/{id}/foto")
				.buildAndExpand(produto.getId())
				.toUri();
		
		ProdutoDTO dto = new ProdutoDTO(produto);
		dto.setNomeProduto(produto.getNomeProduto());
		dto.setDescricaoProduto(produto.getDescricaoProduto());
		dto.setQuantidadeEstoqueProduto(produto.getQuantidadeEstoqueProduto());
		dto.setValorUnitarioProduto(produto.getValorUnitarioProduto());
		dto.setCategoria(produto.getCategoria());


		dto.setUrlProduto(uri.toString());
		return dto;
	}

	

	public Optional<Produto> findById(Long id) {
		return prodRepo.findById(id);
	}

	public void deleteById(Long id) {
		prodRepo.deleteById(id);
	}

	public Produto findById(Produto produto) {
		return prodRepo.findById(produto);
	}

	public Produto save(Produto produto) {
		return prodRepo.save(produto);

	}
}
