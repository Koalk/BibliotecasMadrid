package com.codinghome.bibliouned.view;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioExternoView {
	
	private String identificador;
	private String biblioteca;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nifPasaporte;
	private String mail;
	private String telefono;
	private String localidad;
	private String provincia;
	private String codigoPostal;
	private String direccion;
	private String observaciones;
	private String foto;
	
	public UsuarioExternoView() {}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(String biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	@NotEmpty(message = "Campo obligatorio.")
	@Size(max = 64, message="No puede superar 64 caracteres.")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@NotEmpty(message = "Campo obligatorio.")
	@Size(max = 64, message="No puede superar 64 caracteres.")
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	@Size(max = 64, message="No puede superar 64 caracteres.")
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	@NotEmpty(message = "Campo obligatorio.")
	@Size(max = 15, message="No puede superar 15 caracteres.")
	public String getNifPasaporte() {
		return nifPasaporte;
	}
	public void setNifPasaporte(String nifPasaporte) {
		this.nifPasaporte = nifPasaporte;
	}
	
	@Size(max = 128, message="No puede superar 128 caracteres.")
	@Email
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Size(min = 9, max = 15, message="Debe tener entre 9 y 15 caracteres.")
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Size(max = 64, message="No puede superar 64 caracteres.")
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Size(max = 64, message="No puede superar 64 caracteres.")
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Size(min = 5, max = 5, message="Debe ser de 5 caracteres.")
	@Pattern(regexp="^(01(\\d){2}[1-9])|[1-5]\\d{4}$", message = "El código postal debe estar comprendido entre el 01001 y el 59999")
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@Size(max = 256, message="No puede superar 256 caracteres.")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Size(max = 256, message="No puede superar 256 caracteres.")
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@NotEmpty(message = "Debe añadir una foto.")
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
