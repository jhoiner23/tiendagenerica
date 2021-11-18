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
@Table(name = "clientes")
public final class ClienteDTO {

    @Id
    private Long cedula_cliente;
    private String direccion_cliente;
    private String email_cliente;
    private String nombre_cliente;
    private String telefono_cliente;
    private Boolean disabled = false;
	public Long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getTelefono_cliente() {
		return telefono_cliente;
	}
	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}



}
