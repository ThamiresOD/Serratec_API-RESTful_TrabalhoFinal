package org.serratec.ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.domain.dto.ProdutoDTO;
import org.serratec.ecommerce.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
//	@GetMapping
//	public List<Produto> getProdutos(){
//		return produtoService.findAll();
//	}
	
	@GetMapping
	@ApiOperation(value="Listagem de todos os produtos")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna a lista de produtos"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
	public List<ProdutoDTO> getProdutos(ProdutoDTO produtoDTO){
	List<Produto> produtos = produtoService.findAll();
		return ProdutoDTO.converter(produtos);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Busca de produto por ID")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna produto especifico"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
	public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id) {
		Optional<Produto> produto = produtoService.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new ProdutoDTO(produto.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto inserirProduto(@RequestBody Produto novo_produto) {
		return produtoService.inserir(novo_produto);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Produto> produtoBanco = produtoService.findById(id);
		if (!produtoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produtoService.deleteById(id);
		return ResponseEntity.noContent().build();	
	}
	
}
