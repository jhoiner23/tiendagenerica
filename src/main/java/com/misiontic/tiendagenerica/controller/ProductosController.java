package com.misiontic.tiendagenerica.controller;

import com.misiontic.tiendagenerica.model.ProductosDTO;
import com.misiontic.tiendagenerica.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public final class ProductosController {

    @Autowired
    private ProductosRepository repository;

    @GetMapping("/listar")
    public ArrayList<ProductosDTO> listaproductos(){
        return (ArrayList<ProductosDTO>) repository.findAll();
    }

    @PostMapping("/registrar")
    public ProductosDTO create(@RequestBody ProductosDTO Clientes) {
        return repository.save(Clientes);
    }

    @DeleteMapping( path = "/{codigo_producto}")
    public void deleteById(@PathVariable("codigo_producto") Long codigo_producto){
        repository.deleteById(codigo_producto);
    }

    @PutMapping("actualizar")
    public ProductosDTO update(@RequestBody ProductosDTO clientes) {
        return repository.save(clientes);
    }

    @GetMapping( path = "/{codigo_producto}")
    public Optional<ProductosDTO> getProduct(@PathVariable("codigo_producto") Long cedula_cliente) {
        return repository.findById(cedula_cliente);

    }

    @DeleteMapping( "/deleteAll" )
    public void deleteAll() {
        repository.deleteAll();
    }

}
