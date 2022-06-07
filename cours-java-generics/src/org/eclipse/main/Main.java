package org.eclipse.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.classes.Etudiant;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Etudiant> etudiant = new ArrayList<Etudiant>(); 
		etudiant.add(new Etudiant("Dupont", "0123"));
		etudiant.add(new Etudiant("Delafontaine","1025"));
		etudiant.add(new Etudiant("Pichon","5520"));
		etudiant.add(new Etudiant("Perrin","0011"));
		etudiant.add(new Etudiant("Delaune","1110"));

		System.out.println(etudiant);
		//etudiant.SearchByNumero(0123);
		System.out.println(SearchByNumero("0123",etudiant));
		System.out.println(SearchByName("Perrin",etudiant));
		System.out.println(DisplayNumero(etudiant));
		
		
		System.out.println("----------------------------EXOS MAP--------------------------------");

		final Map<String, String> mapCatalogue = new HashMap<>();

		mapCatalogue.put("0123", "Dupont");
		mapCatalogue.put("1025", "Delafontaine");
		mapCatalogue.put("5520", "Pichon");
		mapCatalogue.put("0011", "Perrin");
		mapCatalogue.put("9250", "Delaune");

		// afficher la map
		System.out.println(mapCatalogue);

		// trouver les etudiants par leurs numéros
		System.out.println(mapCatalogue.get("0123"));

		// trouver les numéro des étudiants par leur noms
		System.out.println(trouverEtudiantParNom("Dupont", mapCatalogue));
		
		// afficher les numeros
		for (Entry<String, String> entry : mapCatalogue.entrySet()) {
			System.out.println("Les numeros sont : " + entry.getKey());
		}
		

		
//		HashMap<String,String> etudiants = new HashMap<String,String>();
//		etudiants.put("0123","Dupont");
//		etudiants.put("1025","Delafontaine");
//		etudiants.put("5520","Pichon");
//		etudiants.put("0011","Perrin");
//		etudiants.put("1110","Delaune");
//		
//		String name = etudiants.get("0123");
//		
//		System.out.println(name);
//		
//		String numero = etudiants.get("Dupont");
//		
//		System.out.println(numero);
		
		
		
//		for (Entry<Integer,String> etu : etudiants.entrySet());
//		{
//			System.out.println(etu.getKey()+ "");
//		}
		
	
		
	}
	public static String SearchByNumero(String numero,List<Etudiant> liste )
	{
		for( int i = 0 ; i < liste.size(); i++)
		{
			if(liste.get(i).getNumero().equals(numero))
			{
				return liste.get(i).getName();
			}
		}
		return ("Aucun etudiant avec ce numero");
	}
	
	
	
	public static String SearchByName(String name ,List<Etudiant> list)
	{
		for( int i = 0 ; i < list.size(); i++)
		{
			if(list.get(i).getName().equals(name))
			{
				return list.get(i).getNumero();
			}
		}
		return ("Aucun etudiant porte ce nom ");
	}
	
	public static String Hello(String nom)
	{
		return nom;
	}
	
	public static String DisplayNumero(List<Etudiant> list)
	{
		for( int i = 0 ; i < list.size(); i++)
		{
			return list.get(i).getNumero();
		}
		return null;
	}
	
	public static String trouverEtudiantParNom(String nom, Map<String, String> map) {
		Set<String> lesCles = map.keySet();
		boolean trouve = false;
		String nomTrouve = "";
		Iterator<String> monIterateur = lesCles.iterator();
		while (!trouve && monIterateur.hasNext()) {
			nomTrouve = monIterateur.next();
			if (map.get(nomTrouve).equals(nom)) {
				return nomTrouve;
			}
		}
		return ("Aucun etudiant avec ce nom !");
	}
	
}
