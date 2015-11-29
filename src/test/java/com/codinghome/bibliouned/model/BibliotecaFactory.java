package com.codinghome.bibliouned.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The class <code>BibliotecaFactory</code> implements static methods that return instances of the class <code>{@link Biblioteca}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class BibliotecaFactory
 {
	/**
	 * Prevent creation of instances of this class.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	private BibliotecaFactory() {
	}


	/**
	 * Create an instance of the class <code>{@link Biblioteca}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Biblioteca createBiblioteca() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno());
		HashSet<Usuario> set1 = new HashSet<Usuario>();
		set1.add(UsuarioFactory.createUsuario());
		return new Biblioteca("", "", "", set, set1);
	}


	/**
	 * Create an instance of the class <code>{@link Biblioteca}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Biblioteca createBiblioteca2() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno());
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario(), "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(644344036000L)));
		HashSet<Usuario> set1 = new HashSet<Usuario>();
		set1.add(UsuarioFactory.createUsuario());
		set1.add(UsuarioFactory.createUsuario10());
		set1.add(UsuarioFactory.createUsuario2());
		set1.add(UsuarioFactory.createUsuario3());
		set1.add(UsuarioFactory.createUsuario4());
		set1.add(UsuarioFactory.createUsuario5());
		set1.add(UsuarioFactory.createUsuario6());
		set1.add(UsuarioFactory.createUsuario7());
		set1.add(UsuarioFactory.createUsuario8());
		set1.add(UsuarioFactory.createUsuario9());
		return new Biblioteca("0123456789", "0123456789", "0123456789", set, set1);
	}


	/**
	 * Create an instance of the class <code>{@link Biblioteca}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Biblioteca createBiblioteca3() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario(), "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		HashSet<Usuario> set1 = new HashSet<Usuario>();
		set1.add(UsuarioFactory.createUsuario10());
		return new Biblioteca("An��t-1.0.txt", "An��t-1.0.txt", "An��t-1.0.txt", set, set1);
	}


	/**
	 * Create an instance of the class <code>{@link Biblioteca}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Biblioteca createBiblioteca4() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", "0123456789", new Date(644344036000L)));
		HashSet<Usuario> set1 = new HashSet<Usuario>();
		set1.add(UsuarioFactory.createUsuario2());
		return new Biblioteca((String) null, (String) null, (String) null, set, set1);
	}


	/**
	 * Create an instance of the class <code>{@link Biblioteca}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Biblioteca createBiblioteca5() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno((Biblioteca) null, UsuarioFactory.createUsuario10(), "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(1591115236000L)));
		HashSet<Usuario> set1 = new HashSet<Usuario>();
		set1.add(UsuarioFactory.createUsuario3());
		return new Biblioteca("0123456789", "0123456789", "", set, set1);
	}


	/**
	 * Create an instance of the class <code>{@link Biblioteca}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Biblioteca createBiblioteca6() {
		return new Biblioteca();
	}
}