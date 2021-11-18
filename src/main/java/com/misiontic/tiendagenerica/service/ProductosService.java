package com.misiontic.tiendagenerica.service;

import com.misiontic.tiendagenerica.model.ProductosDTO;
import com.misiontic.tiendagenerica.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public final class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public ArrayList<ProductosDTO> listaProductos(){
        return (ArrayList<ProductosDTO>) productosRepository.findAll();
    }
    public ProductosDTO crearProductos(ProductosDTO productos) {
        return productosRepository.save(productos);
    }
    public Optional<ProductosDTO> obtenerPorId(Long id){
        return productosRepository.findById(id);
    }
    public boolean eliminarProductos(Long id) {
        try{
            productosRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    public ProductosDTO actualizarProductos(ProductosDTO clienteRepo) {
        return productosRepository.save(clienteRepo);
    }

}
