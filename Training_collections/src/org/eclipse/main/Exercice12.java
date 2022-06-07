package org.eclipse.main;

import java.util.ArrayList;
import java.util.List;

public class Exercice12 {

	public static void main(String[] args) {
		// Write a Java program to extract a portion of a array list.
		List<String> color = new ArrayList<String>();
		color.add("Jaune");
		color.add("Rouge");
		color.add("Vert");
		color.add("Bleu");
		color.add("Violet");
		System.out.println("List1 :"+color);
		System.out.println("List1 :"+color.subList(2, 4));
	}

}
