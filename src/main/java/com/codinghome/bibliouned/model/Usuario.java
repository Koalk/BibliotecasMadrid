package com.codinghome.bibliouned.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "bibliouned")
public class Usuario implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Biblioteca biblioteca;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String email;
	private String password;
	private Date createTime;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	private Set<UsuarioExterno> usuarioexternos = new HashSet<>(0);

	public Usuario() {
	}

	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public Usuario(Biblioteca biblioteca, String usuario, String email,
			String password, Date createTime, Set<UserRole> userRoles, Set<UsuarioExterno> usuarioexternos) {
		this.biblioteca = biblioteca;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.createTime = createTime;
		this.setUserRoles(userRoles);
		this.usuarioexternos = usuarioexternos;
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

	@Column(name = "nombre", length = 64)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "apellidos", length = 128)
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Column(name = "usuario", nullable = false, length = 64)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 10)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<UsuarioExterno> getUsuarioexternos() {
		return this.usuarioexternos;
	}

	public void setUsuarioexternos(Set<UsuarioExterno> usuarioexternos) {
		this.usuarioexternos = usuarioexternos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
