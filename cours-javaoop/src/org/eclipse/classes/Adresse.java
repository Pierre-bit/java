package org.eclipse.classes;

import org.eclipse.exceptions.IncorrectCodePostalException;

public class Adresse {

	private String rue;
	private int codePostal;
	private String ville;
	
	public Adresse()
	{
		
	}
	
	public Adresse(String rue, int codePostal, String ville) throws IncorrectCodePostalException {
		if (String.valueOf(codePostal).length() != 5)
		{
			throw new IncorrectCodePostalException();
		}
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) throws IncorrectCodePostalException {
		if (String.valueOf(codePostal).length() != 5)
		{
			throw new IncorrectCodePostalException();
		}
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

//	@Override
//	public String toString() {
//		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
//	}
	@Override
	public String toString() {
		return "J'habite "+ rue +" "+codePostal+" "+ville;
	}
	
}
