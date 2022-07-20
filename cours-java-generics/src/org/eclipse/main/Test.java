package org.eclipse.main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.classes.Enseignant;
import org.eclipse.classes.Exemple;
import org.eclipse.classes.Humain;
import org.eclipse.classes.Operation;
import org.eclipse.classes.Personne;
import org.eclipse.classes.Vehicule;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("==============================================================================");
		
		
		Humain<Personne> hum1= new Humain<Personne>();
		Humain<Enseignant> hum2= new Humain<Enseignant>();
		
		//Instruction souligné en rouge car Vehicule n'herite pas de la classe Personne 
		
		//Humain<Vehicule> hum3= new Humain<Vehicule>();
		
		
		
		System.out.println("====================Creation d'un main issu d'une classe générique Exemple ============================");
		
		Exemple<Integer, String> couple = new Exemple<Integer, String>();
		
		couple.setVar1(10);
		couple .setVar2("Bonjour");
		
		
		System.out.println(couple.getVar1().getClass().
		getTypeName()+ " " + couple.getVar1());

		System.out.println(couple.getVar2().getClass().getTypeName() + " " + couple.getVar2());

		System.out.println(couple.getVar2().getClass().
		getTypeName() + " " + couple.getVar2());
		
		System.out.println("====================Creation d'un main issu d'une classe générique Operation ============================");
		
		Operation <Integer> operation1 = new Operation<Integer>(5,3);
		operation1.plus();
		Operation <String> operation2 = new Operation<String>("bon","jour");
		operation2.plus();
		Operation <Double> operation3 = new Operation<Double>(5.2,3.8);
		operation3.plus();
		Operation <Boolean> operation4 = new Operation<Boolean>(true,false);
		operation4.plus();

		System.out.println(couple.getVar2().getClass().
		getTypeName() + " " + couple.getVar2());
		
		System.out.println("==============================================================================");
		
		
		LinkedList l = new LinkedList();
		
		
		l.add(0);
		l.add("bonjour");
		l.addFirst("premier");
		l.addLast("dernier");
		String s = "Salut";
		l.add(s);
		int value = 17 ;
		l.add(value);
		l.remove("dernier");
		l.remove(s);
		//l.remove(value);
		l.remove((Object)value);
		ListIterator li = l.listIterator();
		while (li.hasNext())
		{
			System.out.println(li.next() + " ");
		}
		
		System.out.println("===============================Creation Liste de String===========================");
		
		//Creation d'une liste chaine de String
		LinkedList<String> list = new LinkedList<String>();
		
		// ajout des elements 
		list.add("Hello");
		list.add("Bonjour");
		list.add("Ola");
		
		// ajout d'un element au debut de la liste
		list.addFirst("Salut");
		
		// ajout d'un element a la fin de la liste
		list.addLast("Olé");
		
		// ajout d'un element a l'index 1 
		list.add(1,"Hi");
		
		list.forEach((item) ->System.out.println("List before deleting "+item)); 
		
		// Supprimer le premier et le dernier element
		list.removeFirst();
		list.removeLast();
				
		list.forEach((item) -> System.out.println("List after deleting : " + item));
		for (String item : list)
		{
			System.out.println("List after deleting : " + item);
		}
				
		// Recuperer la valeur selon son indice 
		String val = list.get(2);
		
		// Modifier la valeur selon son indice
		list.set(2, val + "changed");
		
		list.forEach((item) -> System.out.println("List after change : " + item));
		
		
		//Dictionnaire
		
		HashMap<String, Integer> map  = new HashMap<String,Integer>();
		
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		
		Integer v1 = map.get("A");
		System.out.println(v1);
		
		map.remove("C");
		
		
		// affiche l'ensemble des clé valeurs en utilisant entrySet()
		for(Entry<String,Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey()+ " "+ entry.getValue());
		}
		
		
		
	}
	

}
