package org.serratec.ecommerce.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.ecommerce.api.domain.Cliente;
import org.serratec.ecommerce.api.domain.ItemPedido;
import org.serratec.ecommerce.api.domain.Pedido;
import org.serratec.ecommerce.api.domain.Produto;
import org.serratec.ecommerce.api.domain.dto.ItemDTO;
import org.serratec.ecommerce.api.domain.dto.ItemInserirDTO;
import org.serratec.ecommerce.api.domain.dto.PedidoDTO;
import org.serratec.ecommerce.api.domain.dto.PedidoInserirDTO;
import org.serratec.ecommerce.api.repository.ClienteRepository;
import org.serratec.ecommerce.api.repository.ItemPedidoRepository;
import org.serratec.ecommerce.api.repository.PedidoRepository;
import org.serratec.ecommerce.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	ItemPedidoRepository itemPedidoRepo;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ClienteRepository clienteRepo;
	
	public List<PedidoDTO> findAll(){
		List<Pedido> pedidosDB = pedidoRepository.findAll();
		List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
		
		for(Pedido pedidoDB : pedidosDB) {
			PedidoDTO pedidoDTO = new PedidoDTO(pedidoDB);
			List<ItemPedido> itemPedidosDB = itemPedidoRepo.findByPedido(pedidoDB);
			for (ItemPedido itemPedido : itemPedidosDB) {
				pedidoDTO.addItems(new ItemDTO(itemPedido));
			}
			pedidosDTO.add(pedidoDTO);
		}
		return pedidosDTO;
		
	}
	
	public PedidoDTO findById(Long id) {
		Optional<Pedido> pedidoDB = pedidoRepository.findById(id);
		
		PedidoDTO pedidoDTO = new PedidoDTO(pedidoDB.get());
		for (ItemPedido itemPedido : itemPedidoRepo.findByPedido(pedidoDB.get())) {
			pedidoDTO.addItems(new ItemDTO(itemPedido));
		}
		return pedidoDTO;
			}
	
	public PedidoDTO save(PedidoInserirDTO novoPedido) {
		Double valorTotal = 0.; 
		Double valorBruto,valorLiquido;
		PedidoDTO pedidoRes;
		List<ItemPedido> itemsDB = new ArrayList<>();
//		É procurado o cliente especificado no DB
		Optional<Cliente> cliente = clienteRepo.findById(novoPedido.getIdCliente());
		
		//Cria items de acordo com os itemsInserirDTO passados, e adiciona o seu valor ao valor total
		for(ItemInserirDTO item : novoPedido.getItems()) {
			Optional<Produto> produto = produtoRepository.findById(item.getIdProduto());
			
			valorBruto = produto.get().getValorUnitarioProduto() * item.getQuantidade();
			valorLiquido = valorBruto - (valorBruto * (item.getPercentualDesconto()/100));
			valorTotal+= valorLiquido;
			
			ItemPedido novoItem = new ItemPedido(item, valorBruto, valorLiquido, produto.get());
			itemsDB.add(novoItem);
		}
		
		//Cria um pedido com esse valor total
		Pedido pedidoDB = new Pedido(novoPedido, valorTotal, cliente.get());
		pedidoRepository.save(pedidoDB);
		//Cria um DTO de resposta a partir do novo Pedido
		pedidoRes = new PedidoDTO(pedidoDB);
		
		//Para cada pedido novo criado, adicionamos o novo Pedido ao seu relacionamento e salvamos.
		//Também criamos DTOs de resposta pra esses items, e devolvemos junto com o PedidoDTO
		for(ItemPedido itemDB : itemsDB) {
			itemDB.setPedido(pedidoDB);
			itemPedidoRepo.save(itemDB);
			pedidoRes.addItems(new ItemDTO(itemDB));;
		}
		return pedidoRes;
	}
}
