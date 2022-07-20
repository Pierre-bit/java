package app;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	// methode principale de l'application
	public static void main(String[] args) {
		
//		System.out.println("Hello world a tous apres compilation test");
//		String hello ="hello";
//		String sf1=String.format("name is %s",hello);  
//		System.out.println(sf1);
//		String a = "hello" ;
//		String b = "hello";
//		if (a.equals(b)) {
//			System.out.println("ok");
//		}
//		int abb = hello.indexOf("e");
//		System.out.println(abb); 
//		int test = 2;
//		String str3 = ((Integer)test).toString();
//		System.out.println(str3);
//		
//		int w = 8;
//		String str4 = Integer.toString(w);
//		System.out.println(str4);
//		
//		int nb1 = 5;
//		int nb2 = 4;
//		System.out.println("resultat de "+nb1+" et "+nb2+ " est "+(nb1+nb2));
//		
//		// printf = print + string.format
//		System.out.println(String.format("resultat de %d + %d = %d", nb1,nb2,(nb1+nb2)));
//		System.out.printf("resultat de %d + %d = %d", nb1,nb2,(nb1+nb2));
//			
		//declaration de tableau par un for
		String [] sportif = {"judo","boxe","foot"};
		for (int i=0 ; i<sportif.length ; i++)
		{System.out.println(sportif[i]);}
		
		System.out.println("====================================================================");
		
		// declaration de tableau par un foreach
		String [] sports = {"judo","boxe","foot"};
		for (String sport : sports)
		{
			System.out.println(sport);
		}
		
		// Collection dynamique
		
		// length pour les array et size pour les collections
				List<String> names = Arrays.asList("Tom", "Jerry", "Donald");
				
				for(int l = 0; l < names.size(); l++ ) {
					System.out.println(names.get(l));
				}
				
				for (String name : names) {
					System.out.println(name);
				}
				
				names.forEach((name) -> System.out.println(name));
				
		
//		exo1();
//		System.out.println("====================================================================");
//		exo1_2();
//		System.out.println("====================================================================");
//		exo2();
//		System.out.println("====================================================================");
//		exo3();
//		System.out.println("====================================================================");
//		exo4();
//		System.out.println("====================================================================");
//		exo5();				
	}
			
			public static void exo1()
			{
				int nb = 0;
				while (nb<11) 
				{
					if (nb%2 == 0)
						{System.out.println(nb);}
					nb++;
				}
			}
			
			
			public static void exo1_2()
			{
				for (int i = 0 ; i<11 ; i+=2)
				{System.out.println(i);}
			}
	
				
			//2eme exo
	
			public static void exo2() {
				Scanner sc = new Scanner(System.in);
				try
				{
					System.out.println("indiquer une valeur");
					int number = sc.nextInt();
					if (number%2 == 0)
					{System.out.printf("le nombre saisie %d est pair",number);}
					else
					{System.out.printf("le nombre saisie %d est impair",number);}	
				sc.close();
				}
				catch (InputMismatchException e)
				{
					System.out.println("merci d'indiquer un chiffre");
				}
			}
			
			public static void exo3()
			{
				Scanner sc = new Scanner(System.in);
				try
				{	
						System.out.println("indiquer une valeur");
						int nb = sc.nextInt();
						System.out.println("indiquer une valeur");
						int nb2 = sc.nextInt();
						System.out.println("indiquer une valeur");
						int nb3 = sc.nextInt();
							/*if (nb>max)
							{max =nb;}
							i++;*/
						int num = Math.max(nb,nb2);
						num= Math.max(num, nb3);
						System.out.printf("le plus grand nombre saisie est %d",num);
						sc.close();
						
				}
				catch (InputMismatchException e)
				{
					System.out.println("merci d'indiquer un chiffre");
				}
			}
			
			//4eme exo 
			public static void exo4()
			{
				Scanner sc = new Scanner(System.in);
				try
				{	
						
						System.out.println("indiquer un nombre de minutes");
						long min = sc.nextLong();
						long annee = min/525600;
						long jours = (min/525600)/1440;
						long minutes = (min/525600/1440)%365;
						System.out.printf("le nombre de minutes equivaut a %d annee et %d jours et il restera %d minutes"
								,annee,jours,minutes );
						sc.close();
						
				}
				catch (InputMismatchException e)
				{
					System.out.println("merci d'indiquer un chiffre");
				}
			}
			
			
			public static void exo5()
			{
				// Ecrire un programme pour que pour un cours du dollar donné (et qui ne change
				// pas pendant l’exécution du programme),
				// on puisse convertir en euro.
				// Prévoyez un moyen d’arrêter l’exécution du programme.
				double euros, dollar;
				double cours;
				String choix;
				Scanner in = new Scanner(System.in);
				try {
					do {
						System.out.println("Cours du dollar(valeur de 1 dollar)?");
						cours = in.nextDouble();
						System.out.println("Somme en dollar ?");
						dollar = in.nextDouble();
						euros = dollar * cours;
						System.out.println("La somme en euros:" + euros);
						System.out.println("Voulez-vous quitter" + "(tapez q pour quitter)");
						choix = in.next();
					} 
					while (choix == "q");
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public static void exo6()
			{
				Scanner sc = new Scanner(System.in);
				
				try
				{
					int i = 0;
					int sum = 0;
					while (i<5)
					{
						System.out.println("indiquer une valeur");
						int nb = sc.nextInt();
						//System.out.println(nb);
						sum += nb;
						i++;
						
					}
					System.out.printf("la somme des nombres est %d",sum);
					sc.close();
					
				}
				catch (InputMismatchException e)
				{
					System.out.println("merci d'indiquer un chiffre");
				}
			}
			
			
			// toute classe en java herite de la classe objects
			
			
			
	
	

}
