package org.serratec.ecommerce.api.repository;

import org.serratec.ecommerce.api.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}

