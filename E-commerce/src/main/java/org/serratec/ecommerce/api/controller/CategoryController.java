package org.serratec.ecommerce.api.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.ecommerce.api.domain.Categoria;
import org.serratec.ecommerce.api.domain.dto.CategoriaDTO;
import org.serratec.ecommerce.api.domain.dto.CategoriaInserirDTO;
import org.serratec.ecommerce.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/categorias")
public class CategoryController {

	@Autowired
	private CategoriaRepository catRepo;

	@GetMapping
	@Cacheable(value = "listaDeCategorias")
	@ApiOperation(value = "Listagem de todas as categorias cadastradas")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna a lista de categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public Page<CategoriaDTO> getCategorias(
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		Page<Categoria> categorias = catRepo.findAll(paginacao);
		return CategoriaDTO.converter(categorias);
	}

	@GetMapping("/{id}")
	@Cacheable(value = "categoriaPorId")
	@ApiOperation(value = "Busca de categoria por ID")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna a categoria específica"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id) {
		Optional<Categoria> categoria = catRepo.findById(id);
		if (categoria.isPresent()) {
			return ResponseEntity.ok(new CategoriaDTO(categoria.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@CacheEvict(value = "listaDeCategorias", allEntries = true)
	@ApiOperation(value = "Inclusão de categoria(s)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Inclui categoria(s)"),
			@ApiResponse(code = 201, message = "Categoria(s) criada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {
		categoria = catRepo.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoria.getIdCategoria()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeCategorias", allEntries = true)
	@ApiOperation(value = "Update categoria por ID")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna alteração realizada"),		
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long id, @RequestBody CategoriaInserirDTO form) {
		Optional<Categoria> optional = catRepo.findById(id);
		if (optional.isPresent()) {
			Categoria categoria = form.atualizar(id, catRepo);
			return ResponseEntity.ok(new CategoriaDTO(categoria));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeCategorias", allEntries = true)
	@ApiOperation(value = "Remoção de categoria por ID")
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Categoria específica removida"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Categoria> categoriaBanco = catRepo.findById(id);
		if (!categoriaBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		catRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
