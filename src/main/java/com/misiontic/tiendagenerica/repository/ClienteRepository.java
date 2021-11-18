package com.misiontic.tiendagenerica.repository;

import com.misiontic.tiendagenerica.model.ClienteDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteDTO, Long> {

}
