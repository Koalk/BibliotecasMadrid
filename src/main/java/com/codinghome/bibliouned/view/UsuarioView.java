package com.codinghome.bibliouned.view;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;



public class UsuarioView {
	
	private String nombre;
	private String apellidos;
	private String mail;
	private String usuario;
	private String password;
	private String newPassword;
	private String confirmPassword;
	private Boolean enabled;
	private Boolean userRole;
	private Boolean adminRole;
	
	public UsuarioView() {}
	
	@NotEmpty(message = "Campo obligatorio.")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@NotEmpty(message = "Campo obligatorio.")
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Email
	@NotEmpty(message = "Campo obligatorio.")
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
    @NotEmpty(message = "Campo obligatorio.")
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
    @NotEmpty(message = "Campo obligatorio.")
    @Size(min = 6, message = "")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
    @Size(min = 6, message = "")
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public Boolean getUserRole() {
		return userRole;
	}
	public void setUserRole(Boolean userRole) {
		this.userRole = userRole;
	}
	
	public Boolean getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(Boolean adminRole) {
		this.adminRole = adminRole;
	}
}
