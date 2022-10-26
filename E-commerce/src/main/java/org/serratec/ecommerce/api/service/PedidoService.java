package org.serratec.ecommerce.api.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ecommerce.api.domain.ItemPedido;
import org.serratec.ecommerce.api.domain.Pedido;
import org.serratec.ecommerce.api.domain.dto.ItemDTO;
import org.serratec.ecommerce.api.domain.dto.PedidoDTO;
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
}
