package com.misiontic.tiendagenerica.repository;

import com.misiontic.tiendagenerica.model.ProveedoresDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends CrudRepository<ProveedoresDTO, Long> {
}
