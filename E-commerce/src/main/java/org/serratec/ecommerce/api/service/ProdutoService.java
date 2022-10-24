package org.serratec.ecommerce.api.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.ecommerce.api.domain.Foto;
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

	public List<ProdutoDTO> findAll() {
		return prodRepo.findAll().stream().map(p -> adicionarImagemUri(p)).collect(Collectors.toList());
	}

	public ProdutoDTO findById(Long id) {
		return adicionarImagemUri(prodRepo.findById(id).get());
	}


	public ProdutoDTO inserir(ProdutoInserirDTO produto) {
		return new ProdutoDTO(prodRepo.save(new Produto(produto)));
	}

	public ProdutoDTO inserir(ProdutoInserirDTO produtoDTO, MultipartFile file) throws IOException {
		Produto produto = prodRepo.save(new Produto(produtoDTO));
		fotoService.inserir(produto, file);
		return adicionarImagemUri(produto);
	}

	public void deleteById(Long id) {
		Optional<Foto> fotoDB = fotoService.buscarPorIdProduto(id);
		if(fotoDB.isPresent()) {
			fotoService.deleteFoto(fotoDB.get().getId());
		}
		prodRepo.deleteById(id);
	}


	public Produto save(Produto produto) {
		return prodRepo.save(produto);

	}
	
	public ProdutoDTO adicionarImagemUri(Produto produto) {
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/produtos/{id}/foto")
				.buildAndExpand(produto.getId())
				.toUri();
		
		ProdutoDTO dto = new ProdutoDTO(produto);

		dto.setUrlProduto(uri.toString());
		return dto;
	}

}
