package org.eclipse.main;

import java.util.Arrays;
import java.util.List;

import org.eclipse.interfaces.Calcul;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calcul addition = (x,y) -> x + y;
		System.out.println("8 + 2 = " +calculer(8,2,addition));
	}
	private static int calculer(int x , int y , Calcul operation)
	{
		return operation.calc(x,y);
	}
	List<String>sports = Arrays.asList("foot","basket","tennis");
	

}
