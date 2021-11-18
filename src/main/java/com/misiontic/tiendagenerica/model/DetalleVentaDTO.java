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
@Table(name = "detalle_ventas")
public final class DetalleVentaDTO {

    @Id
    private Long codigo_detalle_venta;

    private int cantidad_producto;
    private Long codigo_producto;
    private Long codigo_venta;
    private double valor_total;
    private double valor_venta;
    private double valor_iva;



}
