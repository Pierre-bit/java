package org.eclipse.classes;

import java.util.Random;
import java.util.Scanner;

public class Methodes {
	
	
	public static double calculMoyenneVitesse(double distance, double temps)
	{
		return 0;
	}
	
	public static boolean verifyBuildTriangle(int mesure1, int mesure2 , int mesure3)
	{
		return true;
	}
	
	public static int calculPgcd (int nombre1 , int nombre2 )
	{
		return 0;
	}
	
	public static String writeInitialPersonnes( String name)
	{
		return "";
	}
	
	public int returnPgvalNumber(int number1 , int number2)
	{
		if (number1<number2) {
			return number2;
		}
		else 
		{
			return number1;
		}
	}
	
	public void repeatWord(String mot)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("combien de fois voulez-vous répétez le mot");
		int repeat = sc.nextInt();
		for (int i = 0 ; i < repeat ; i++)
		{
			System.out.print(mot + " ");
		}
		sc.close();
		
	}
	public double selectNumber(int lowerBound,int upperBound) 
	{
	    int range = (upperBound - lowerBound);
	    int random = (int)(Math.random() * range) + lowerBound;
	    return random;
	}
	
	//Une fonction qui teste si un tableau contient une valeur spécifique
	public boolean contentValue (int value)
	{
		Random rd = new Random();
		
		int [] arr = new int [10];
		for (int i=0;i<arr.length;i++)
		{
			arr[i] = rd.nextInt();
			if (value==arr[i])
			{
				return true;
			}
			System.out.println(arr[i]);	
		}
		
		return false;
	}
	
	 
	
	
	
	
	
	
	
	
	
}


