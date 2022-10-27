package org.serratec.ecommerce.api.repository;

import java.util.List;

import org.serratec.ecommerce.api.domain.ItemPedido;
import org.serratec.ecommerce.api.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
	
	List<ItemPedido> findByPedido(Pedido pedido);
}
