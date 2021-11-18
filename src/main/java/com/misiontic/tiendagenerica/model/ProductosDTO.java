package com.misiontic.tiendagenerica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "productos")
public final class ProductosDTO {

    @Id
    private Long codigo_producto;

    private double iva_compra;
    private Long nit_proveedor;
    private String nombre_producto;
    private double precio_compra;
    private double precio_venta;


}
