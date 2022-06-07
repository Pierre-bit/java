package org.eclipse.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Write a Java program to create a new array list, 
		//add some colors (string) and print out the collection

		List<String> color = new ArrayList<String>();
		color.add("Jaune");
		color.add("Rouge");
		color.add("Vert");
		color.add("Bleu");
		color.add("Violet");
		
		//System.out.println(color);
		
	//Write a Java program to iterate through all elements in a array list
		for (String item : color)
		{
			System.out.println(item);
		}
	//Write a Java program to insert an element into the array list at the first position
		
		color.add(0, "noir");
		//System.out.println(color);
		
	//Write a Java program to retrieve an element (at a specified index) from a given array list
		//System.out.println("Donner un index");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		//System.out.println(color.get(index));
	//Write a Java program to update specific array element by given element.
		String item = color.get(index);
		color.set(index, "blanc");
		//System.out.println(color);
	// Write a Java program to remove the third element from a array list
		color.remove(2);
		//System.out.println(color);
	//Write a Java program to search an element in a array list
		//System.out.println(color.contains("noir"));
		//System.out.println("Donner un mot");
		String items = sc.next();
		if(color.contains(items))
		{
			//System.out.println("element present");
		}
		else
		{
			//System.out.println("Element non trouvé");
		}
		//Write a Java program to copy one array list into another.
		List<String> letters = new ArrayList<String>();
		color.add("a");
		color.add("b");
		color.add("c");
		color.add("d");
		color.add("e");
		System.out.println(color);
		System.out.println(letters);
		Collections.copy(color, letters);
		System.out.println(color);
		System.out.println(letters);
	}
	

}
