package org.serratec.ecommerce.api.controller;

import java.util.List;

import org.serratec.ecommerce.api.domain.dto.PedidoDTO;
import org.serratec.ecommerce.api.domain.dto.PedidoInserirDTO;
import org.serratec.ecommerce.api.exception.ClienteNotFoundException;
import org.serratec.ecommerce.api.exception.PedidoNotFoundException;
import org.serratec.ecommerce.api.exception.ProdutoNotFoundException;
import org.serratec.ecommerce.api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/pedidos")
public class PedidoController {
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
	@ApiOperation(value="Listagem de todos os pedidos")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna a lista de clientes"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
	public ResponseEntity<List<PedidoDTO>> getPedido(){
		return ResponseEntity.ok(pedidoService.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Listagem de todos os pedidos")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna a lista de clientes"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
	public ResponseEntity<PedidoDTO> getPedidoPorID(@PathVariable Long id){
		return ResponseEntity.ok(pedidoService.findById(id));
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value="Criação de novo cliente")
    @ApiResponses(value= {
    @ApiResponse(code=201, message="Retorna o cliente inserido"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
	public ResponseEntity<PedidoDTO> inserirPedido(@RequestBody PedidoInserirDTO novoPedido) throws ClienteNotFoundException, ProdutoNotFoundException{
		return ResponseEntity.ok(pedidoService.save(novoPedido));
	}
	
	@PutMapping
	@ApiOperation(value="Aualização de cliente")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna cliente atualizado"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })
	public ResponseEntity<PedidoDTO> updatePedido(@RequestBody PedidoDTO novoPedido) throws PedidoNotFoundException{
		return ResponseEntity.ok(pedidoService.update(novoPedido));
	}
	
	@DeleteMapping
	@ApiOperation(value="Remoção de cliente")
    @ApiResponses(value= {
    @ApiResponse(code=200, message="Retorna cliente atualizado"),
    @ApiResponse(code=401, message="Erro de autenticação"),
    @ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
    @ApiResponse(code=404, message="Recurso não encontrado"),
    @ApiResponse(code=505, message="Exceção interna da aplicação"),
    })	
	public ResponseEntity<Void> deletePedido(@PathVariable Long id) throws PedidoNotFoundException{
		pedidoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	}
	