package com.codinghome.bibliouned.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarioexterno", catalog = "bibliouned")
public class UsuarioExterno implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Biblioteca biblioteca;
	private Usuario usuario;
	private String identificador;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nifPasaporte;
	private String mail;
	private String telefono;
	private String localidad;
	private String codigoPostal;
	private String direccion;
	private String observaciones;
	private Date createTime;

	public UsuarioExterno() {
	}

	public UsuarioExterno(Biblioteca biblioteca, Usuario usuario,
			String identificador, String nombre, String apellido1,
			String apellido2, String nifPasaporte, String mail,
			String telefono, String localidad, String codigopostal,
			String direccion, String observaciones, Date createTime) {
		this.biblioteca = biblioteca;
		this.usuario = usuario;
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nifPasaporte = nifPasaporte;
		this.mail = mail;
		this.telefono = telefono;
		this.localidad = localidad;
		this.codigoPostal = codigopostal;
		this.direccion = direccion;
		this.observaciones = observaciones;
		this.createTime = createTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Biblioteca_id")
	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Usuario_id")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "identificador", length = 15)
	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido1", length = 45)
	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "apellido2", length = 45)
	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "nif_pasaporte", length = 45)
	public String getNifPasaporte() {
		return this.nifPasaporte;
	}

	public void setNifPasaporte(String nifPasaporte) {
		this.nifPasaporte = nifPasaporte;
	}

	@Column(name = "mail")
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "telefono", length = 15)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "localidad", length = 45)
	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Column(name = "codigopostal", length = 45)
	public String getCodigopostal() {
		return this.codigoPostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigoPostal = codigopostal;
	}

	@Column(name = "direccion", length = 45)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
