package org.eclipse.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercice11 {

	public static void main(String[] args) {
		// Write a Java program to reverse elements in a array list.
		List<String> color = new ArrayList<String>();
		color.add("Jaune");
		color.add("Rouge");
		color.add("Vert");
		color.add("Bleu");
		color.add("Violet");
		System.out.println("List1 :"+color);
		Collections.reverse(color);
		System.out.println("List1 :"+color);
		
	}

}
