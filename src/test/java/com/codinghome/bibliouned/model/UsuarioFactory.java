package com.codinghome.bibliouned.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * The class <code>UsuarioFactory</code> implements static methods that return instances of the class <code>{@link Usuario}</code>.
 *
 * @generatedBy CodePro at 28/11/15 14:05
 * @author Daniel
 * @version $Revision: 1.0 $
 */
public class UsuarioFactory
 {
	/**
	 * Prevent creation of instances of this class.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	private UsuarioFactory() {
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno());
		HashSet<Usuario> set1 = new HashSet<Usuario>();
		set1.add((Usuario) null);
		Biblioteca biblioteca = new Biblioteca("", "", "", set, set1);
		HashSet<UserRole> set2 = new HashSet<UserRole>();
		set2.add((UserRole) null);
		HashSet<UsuarioExterno> set3 = new HashSet<UsuarioExterno>();
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(1591115236000L)));
		return new Usuario(biblioteca, "0123456789", "0123456789", "", new Date(0L), set2, set3);
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario2() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno());
		HashSet<Usuario> set1 = new HashSet<Usuario>();
		set1.add((Usuario) null);
		Biblioteca biblioteca = new Biblioteca("", "", "", set, set1);
		HashSet<UserRole> set2 = new HashSet<UserRole>();
		set2.add(UserRoleFactory.createUserRole());
		HashSet<UsuarioExterno> set3 = new HashSet<UsuarioExterno>();
		set3.add(new UsuarioExterno());
		return new Usuario(biblioteca, "", "", "", new Date(1591115236000L), set2, set3);
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario3() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno());
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(644344036000L)));
		TreeSet<Usuario> set1 = new TreeSet<Usuario>();
		set1.add((Usuario) null);
		Biblioteca biblioteca = new Biblioteca("0123456789", "0123456789", "0123456789", set, set1);
		TreeSet<UserRole> set2 = new TreeSet<UserRole>();
		set2.add(UserRoleFactory.createUserRole());
		HashSet<UsuarioExterno> set3 = new HashSet<UsuarioExterno>();
		set3.add(new UsuarioExterno());
		return new Usuario(biblioteca, "An��t-1.0.txt", "An��t-1.0.txt", "An��t-1.0.txt", new Date(644344036000L), set2, set3);
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario4() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno());
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(644344036000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(1591115236000L)));
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(644344036000L)));
		TreeSet<Usuario> set1 = new TreeSet<Usuario>();
		set1.add((Usuario) null);
		Biblioteca biblioteca = new Biblioteca("0123456789", "0123456789", "0123456789", set, set1);
		TreeSet<UserRole> set2 = new TreeSet<UserRole>();
		set2.add(UserRoleFactory.createUserRole());
		HashSet<UsuarioExterno> set3 = new HashSet<UsuarioExterno>();
		set3.add(new UsuarioExterno());
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", "0123456789", new Date(644344036000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(1591115236000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(644344036000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(1591115236000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(644344036000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(1591115236000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(644344036000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(1591115236000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(644344036000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(1591115236000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(644344036000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(1591115236000L)));
		set3.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(644344036000L)));
		return new Usuario(biblioteca, "0123456789", "0123456789", "0123456789", new Date(644344036000L), set2, set3);
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario5() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		Biblioteca biblioteca = new Biblioteca("An��t-1.0.txt", "An��t-1.0.txt", "An��t-1.0.txt", set, new HashSet<Usuario>());
		HashSet<UsuarioExterno> set1 = new HashSet<UsuarioExterno>();
		set1.add(new UsuarioExterno());
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", "0123456789", new Date(644344036000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(1591115236000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "", new Date(644344036000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(1591115236000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", "0123456789", new Date(644344036000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(1591115236000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", new Date(644344036000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(1591115236000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "0123456789", new Date(644344036000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(1591115236000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", new Date(644344036000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(1591115236000L)));
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new Date(644344036000L)));
		return new Usuario(biblioteca, (String) null, (String) null, (String) null, new Date(946713599000L), new HashSet<UserRole>(), set1);
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario6() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		Biblioteca biblioteca = new Biblioteca("An��t-1.0.txt", "An��t-1.0.txt", "An��t-1.0.txt", set, new HashSet<Usuario>());
		HashSet<UsuarioExterno> set1 = new HashSet<UsuarioExterno>();
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "", "", "", "", "", "", "", "", "", "", "", new Date(1591115236000L)));
		return new Usuario(biblioteca, "An��t-1.0.txt", "An��t-1.0.txt", "An��t-1.0.txt", new Date(946713599000L), new HashSet<UserRole>(), set1);
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario7() {
		HashSet<UsuarioExterno> set = new HashSet<UsuarioExterno>();
		set.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", "0123456789", new Date(644344036000L)));
		Biblioteca biblioteca = new Biblioteca((String) null, (String) null, (String) null, set, new TreeSet<Usuario>());
		HashSet<UsuarioExterno> set1 = new HashSet<UsuarioExterno>();
		set1.add(new UsuarioExterno((Biblioteca) null, (Usuario) null, "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "0123456789", "", "", "0123456789", new Date(644344036000L)));
		return new Usuario(biblioteca, (String) null, (String) null, (String) null, new Date(946713600000L), new TreeSet<UserRole>(), set1);
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario8() {
		return new Usuario("", "");
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario9() {
		return new Usuario("0123456789", "0123456789");
	}


	/**
	 * Create an instance of the class <code>{@link Usuario}</code>.
	 *
	 * @generatedBy CodePro at 28/11/15 14:05
	 */
	public static Usuario createUsuario10() {
		return new Usuario();
	}
}