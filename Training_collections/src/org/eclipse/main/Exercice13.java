package org.eclipse.main;

import java.util.ArrayList;
import java.util.List;

public class Exercice13 {

	public static void main(String[] args) {
		// Write a Java program to compare two array lists
		List<String> color = new ArrayList<String>();
		color.add("Jaune");
		color.add("Rouge");
		color.add("Vert");
		color.add("Bleu");
		color.add("Violet");
		
		List<String> letters = new ArrayList<String>();
		letters.add("a");
		letters.add("b");
		letters.add("c");
		letters.add("d");
		letters.add("e");
		
		ArrayList<String> c3 = new ArrayList<String>();
		for (String c : color)
		{
			c3.add(letters.contains(c)?"oui":"non");
		}
		System.out.println(c3);
	}

}
