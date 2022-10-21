package org.serratec.ecommerce.api.repository;

import org.serratec.ecommerce.api.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Produto, Long>{

}

