package org.serratec.ecommerce.api.repository;

import org.serratec.ecommerce.api.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends JpaRepository<Produto, Long>{

}

