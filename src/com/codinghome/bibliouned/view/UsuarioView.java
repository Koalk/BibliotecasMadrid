package com.codinghome.bibliouned.view;

import org.hibernate.validator.constraints.NotEmpty;



public class UsuarioView {
	
	private String usuario;
	private String password;
	private String confirmPassword;
	
	public UsuarioView() {}
	
    @NotEmpty(message = "Campo obligatorio.")
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
    @NotEmpty(message = "Campo obligatorio.")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    @NotEmpty(message = "Campo obligatorio.")
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
