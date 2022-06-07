package org.eclipse.classes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Etudiant {
	
	private int id;
	private String name;
	private String numero;
	private int count;
	
	public Etudiant() {

	}

	public Etudiant(String name, String numero) {
		this.id = ++count;
		this.name = name;
		this.numero = numero;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return numero+":"+name;
	}
	
	
}
