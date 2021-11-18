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
@Table(name = "proveedores")
public final class ProveedoresDTO {
    @Id
    private Long nit_proveedor;

    private String ciudad_proveedor;
    private String direccion_proveedor;
    private String nombre_proveedor;
    private String telefono_venta;

    private Boolean disabled = false;

	public Long getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getTelefono_venta() {
		return telefono_venta;
	}

	public void setTelefono_venta(String telefono_venta) {
		this.telefono_venta = telefono_venta;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public ProveedoresDTO(Long nit_proveedor, String ciudad_proveedor, String direccion_proveedor,
			String nombre_proveedor, String telefono_venta, Boolean disabled) {
		super();
		this.nit_proveedor = nit_proveedor;
		this.ciudad_proveedor = ciudad_proveedor;
		this.direccion_proveedor = direccion_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.telefono_venta = telefono_venta;
		this.disabled = disabled;
	}

	@Override
	public String toString() {
		return "ProveedoresDTO [nit_proveedor=" + nit_proveedor + ", ciudad_proveedor=" + ciudad_proveedor
				+ ", direccion_proveedor=" + direccion_proveedor + ", nombre_proveedor=" + nombre_proveedor
				+ ", telefono_venta=" + telefono_venta + ", disabled=" + disabled + "]";
	}




}
