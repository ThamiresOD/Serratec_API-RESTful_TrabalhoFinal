package org.serratec.ecommerce.api.controller;

import java.util.List;

import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.domain.dto.ClienteInserirDTO;
import org.serratec.ecommerce.api.exception.ClienteNotFoundException;
import org.serratec.ecommerce.api.exception.CpfException;
import org.serratec.ecommerce.api.exception.EmailException;
import org.serratec.ecommerce.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	@Cacheable(value = "listaDeClientes")
	@ApiOperation(value = "Listagem de todos os clientes cadastrados")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna a lista de clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<Cliente>> getClientes() {
		return ResponseEntity.ok(clienteService.findAll());
	}

	@GetMapping("/{id}")
	@Cacheable(value = "clientePorCpf")
	@ApiOperation(value = "Busca de cliente por ID")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna o cliente específico"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) throws ClienteNotFoundException {
		return ResponseEntity.ok(clienteService.findById(id));
	}

	@PostMapping
	@CacheEvict(value = "listaDeClientes", allEntries = true)
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Inclusão de cliente(s)")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Inclui cliente(s)"),
			@ApiResponse(code = 201, message = "Cliente(s) criado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public Cliente inserirCliente(@RequestBody ClienteInserirDTO novoCliente) throws CpfException, EmailException {
		return clienteService.inserir(novoCliente);

	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "listaDeClientes", allEntries = true)
	@ApiOperation(value = "Remoção de Cliente por ID")
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Cliente específico removido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id) throws ClienteNotFoundException {
		clienteService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	@CacheEvict(value = "listaDeClientes", allEntries = true)
	@ApiOperation(value = "Update cliente por ID")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna alteração realizada"),		
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente updateCliente)
			throws ClienteNotFoundException, CpfException, EmailException {
		return ResponseEntity.ok(clienteService.updateCliente(updateCliente));
	}

}
