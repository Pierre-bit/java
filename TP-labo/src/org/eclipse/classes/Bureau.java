package org.eclipse.classes;

import java.util.List;

public class Bureau {

	private int id;
	private int code;
	private String name;
	private List<Chercheur> search  ;
	private static int count;
	
	public Bureau() {
		
	}

	public Bureau(int code, String name, List<Chercheur> search) {
		super();
		this.id = ++count;
		this.code = code;
		this.name = name;
		this.search = search;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chercheur> getSearch() {
		return search;
	}

	public void setSearch(List<Chercheur> search) {
		this.search = search;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Le Bureau "+name+" "+code+" appartenant au chercheur "+search;
	}
	
	
	
	
	
	
}
