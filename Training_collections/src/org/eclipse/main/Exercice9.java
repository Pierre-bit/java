package org.eclipse.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercice9 {

	public static void main(String[] args) {
		//Write a Java program to copy one array list into another.
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
		
		System.out.println("List1 :"+color);
		System.out.println("List2 :"+letters);
		Collections.copy(letters, color);
		System.out.println("List1 :"+color);
		System.out.println("List2 :"+letters);
	}

}
