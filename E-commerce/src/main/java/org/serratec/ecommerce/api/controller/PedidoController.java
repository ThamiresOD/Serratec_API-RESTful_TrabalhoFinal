package org.serratec.ecommerce.api.controller;

import java.util.List;

import org.serratec.ecommerce.api.domain.dto.PedidoDTO;
import org.serratec.ecommerce.api.domain.dto.PedidoInserirDTO;
import org.serratec.ecommerce.api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<PedidoDTO> inserirPedido(@RequestBody PedidoInserirDTO novoPedido){
		return pedidoService.save(novoPedido);
	}
}
	