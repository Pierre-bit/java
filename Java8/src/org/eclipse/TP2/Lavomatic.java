package org.eclipse.TP2;

public class Lavomatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImachineAlaver ime;
		ime = (message) -> {
			System.out.println("Bonjour "+message);
		};
		ime.demarrer("Elle demarre");
		
		
		ImachineAlaver  ime2 = (message) -> {
			if (message instanceof String) {
				System.out.println("Bonjour "+message);
			}
			else {
				System.out.println(message+"n'est pas une chaine de caractere");
			}
		};
		ime.demarrer("Elle demarre");
	}

}
