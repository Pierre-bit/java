package org.eclipse.classes;

public class Vehicule {
	
	private int marque;

	public int getMarque() {
		return marque;
	}

	public void setMarque(int marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Vehicule [marque=" + marque + "]";
	}
	
	
}

