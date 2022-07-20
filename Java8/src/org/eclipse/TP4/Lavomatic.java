package org.eclipse.TP4;

import org.eclipse.TP4.ImachineAlaver;

public class Lavomatic {

	public static void main(String[] args) {
		
		ImachineAlaver ime;
		ime = message -> "Bonjour "+message;
		System.out.println(ime.demarrer(" elle demarre"));	
		
		//2eme version
		
		final String value = "Bonjour";
		
		ImachineAlaver ime2 = message -> value+message;
		System.out.println(ime.demarrer(" elle demarre"));
	}
}
