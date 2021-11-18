package com.misiontic.tiendagenerica.controller;


import com.misiontic.tiendagenerica.model.VentasDTO;
import com.misiontic.tiendagenerica.repository.DetalleVentaRepository;
import com.misiontic.tiendagenerica.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/ventas")
public final class VentasControllers {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @GetMapping("/listar")
    public ArrayList<VentasDTO> listaclientes(){
        return (ArrayList<VentasDTO>) ventasRepository.findAll();
    }

    @PostMapping("/registrar")
    public VentasDTO crearUsuarios(@RequestBody VentasDTO Cliente) {
        System.out.println("===========================");
        System.out.println(Cliente.getCodigo_venta());
        System.out.println("===========================");
        return ventasRepository.save(Cliente);
    }

    @DeleteMapping( path = "eliminar/{cedula_usuario}")
    public void eliminarPorId(@PathVariable("cedula_usuario") Long cedula_usuario){
        this.ventasRepository.deleteById(cedula_usuario);
    }

    @PutMapping("/actualizar")
    public VentasDTO actualizar(@RequestBody VentasDTO cliente) {
        return this.ventasRepository.save(cliente);
    }


    @GetMapping( path = "/get/{cedula_cliente}")
    public Optional<VentasDTO> obtenerclientes(@PathVariable("cedula_cliente") Long cedula_cliente) {
        return this.ventasRepository.findById(cedula_cliente);

    }

    @GetMapping( path = "/getNumberRegisters")
    public String getUltimateID() {
        return ventasRepository.count()+"";
    }

    @GetMapping( path = "/getNumberRegistersDetails")
    public String getUltimateID_details() {
        return detalleVentaRepository.count()+"";
    }

}
