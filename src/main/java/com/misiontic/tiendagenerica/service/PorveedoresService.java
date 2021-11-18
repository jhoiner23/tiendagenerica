package com.misiontic.tiendagenerica.service;

import com.misiontic.tiendagenerica.model.ProveedoresDTO;
import com.misiontic.tiendagenerica.repository.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public final class PorveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    public ArrayList<ProveedoresDTO> listaproveedores(){
        return (ArrayList<ProveedoresDTO>) proveedoresRepository.findAll();
    }
    public ProveedoresDTO crearproveedores(ProveedoresDTO clientes) {
        return proveedoresRepository.save(clientes);
    }
    public Optional<ProveedoresDTO> obtenerPorId(Long id){
        return proveedoresRepository.findById(id);
    }
    public boolean eliminarproveedores(Long id) {
        try{
            proveedoresRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    public ProveedoresDTO Actualizarproveedores(ProveedoresDTO proveedores) {
        return proveedoresRepository.save(proveedores);
    }
}
