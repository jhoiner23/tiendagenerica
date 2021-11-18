package com.misiontic.tiendagenerica.controller;

import com.misiontic.tiendagenerica.model.ProveedoresDTO;
import com.misiontic.tiendagenerica.repository.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/proveedores")
public final class ProveedoresController {

    @Autowired
    private ProveedoresRepository repository;

    @GetMapping("/listar")
    public ArrayList<ProveedoresDTO> listaProveedores(){
        ArrayList<ProveedoresDTO> list = (ArrayList<ProveedoresDTO>) repository.findAll();
        list.removeIf( proveedor -> (proveedor.getDisabled()) );
        return list;
    }

    @PostMapping("/registrar")
    public ProveedoresDTO crearProveedores(@RequestBody ProveedoresDTO prove) {
        return this.repository.save(prove);
    }

    @DeleteMapping( path = "/eliminar/{cedula_usuario}")
    public void eliminarPorId(@PathVariable("nit_proveedor") Long nit_proveedor){
        ProveedoresDTO proveedor = repository.findById(nit_proveedor).get();
        proveedor.setDisabled(true);
        actualizar(proveedor);
    }

    @PutMapping("/actualizar")
    public ProveedoresDTO actualizar(@RequestBody ProveedoresDTO clientes) {
        return repository.save(clientes);
    }

    @GetMapping( path = "obtener_proveedor/{nit_proveedor}")
    public ProveedoresDTO getVendorById(@PathVariable("nit_proveedor") Long nit_proveedor) {
        ProveedoresDTO proveedor = repository.findById(nit_proveedor).get();
        if ( proveedor == null ) return null;
        else if( proveedor.getDisabled() ) return null;
        return proveedor;
    }

}
