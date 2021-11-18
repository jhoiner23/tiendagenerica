package com.misiontic.tiendagenerica.repository;

import com.misiontic.tiendagenerica.model.DetalleVentaDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends CrudRepository<DetalleVentaDTO, Long> {

}
