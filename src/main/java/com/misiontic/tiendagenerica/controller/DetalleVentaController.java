package com.misiontic.tiendagenerica.controller;

import com.misiontic.tiendagenerica.model.DetalleVentaDTO;
import com.misiontic.tiendagenerica.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/detalles_ventas")
public final class DetalleVentaController {

    @Autowired
    private DetalleVentaRepository repository;

    @GetMapping("/listar")
    public ArrayList<DetalleVentaDTO> listaClientes(){
        return (ArrayList<DetalleVentaDTO>) repository.findAll();
    }

    @PostMapping("/registrar")
    public DetalleVentaDTO crearUsuarios(@RequestBody DetalleVentaDTO Cliente) {
        return repository.save(Cliente);
    }

    @DeleteMapping( path = "eliminar/{cedula_usuario}")
    public void eliminarPorId(@PathVariable("cedula_usuario") Long cedula_usuario){
        repository.deleteById(cedula_usuario);
    }

    @PutMapping("/actualizar")
    public DetalleVentaDTO actualizar(@RequestBody DetalleVentaDTO cliente) {
        return this.repository.save(cliente);
    }


    @GetMapping( path = "/get/{cedula_cliente}")
    public Optional<DetalleVentaDTO> obtenerClientes(@PathVariable("cedula_cliente") Long cedula_cliente) {
        return repository.findById(cedula_cliente);

    }

    @GetMapping( path = "/getNumberRegisters")
    public String getUltimateID() {
        return repository.count()+"";
    }


}
