package org.eclipse.TP3;

public class Lavomatic   {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ImachineAlaver ime;
		ime = (message) -> {
			return "Bonjour "+message;
		};
		System.out.println(ime.demarrer(" elle demarre"));	
		
		//2eme version
		
		final String value = "Bonjour";
		
		ImachineAlaver ime2 = (message) -> {
			return value+message;
		};
		System.out.println(ime.demarrer(" elle demarre"));
	}
}
