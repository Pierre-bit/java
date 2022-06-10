package org.eclipse.TP5;

public class Lavomatic implements ImachineAlaver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImachineAlaver ime = message -> "Bonjour "+message;
		System.out.println(ime.demarrer(" elle demarre"));	
	}
	
	@Override
	public String demarrer(String message) {
		// TODO Auto-generated method stub
		return message;
	}
}
