package com.example.main;

import com.example.classes.Etudiant;
import com.example.classes.Filiere;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Filiere f1 = new Filiere(1,"Sport");
		Filiere f2 = new Filiere(2,"Math");
		Filiere f3 = new Filiere(3,"Informatique");
		Etudiant etudiant1= new Etudiant("Fett","Boba",f1);
		Etudiant etudiant2= new Etudiant("Solo","Han",f2);
		Etudiant etudiant3= new Etudiant("Skywalker","Luke",f2);
		Etudiant etudiant4= new Etudiant("Kenobi","Obi-Wan",f3);
		Etudiant etudiant5= new Etudiant("Skywalker","Anakin",f3);
		
		Filiere [] filiere = {f1,f2,f3};
		Etudiant [] etudiant = {etudiant1,etudiant2,etudiant3,etudiant4,etudiant5};
//		for (int i =0 ; i<fil.length;i++ )
//		{
//			System.out.println(fil[i]);
//		}
		
		 
//		for (int i=0 ; i<filiere.length; i++)
//		{
//			//System.out.println(filiere[i].getLibelle()+ " ");
//			for (int j=0 ; j<etudiant.length;j++)
//			{
//				if (etudiant[j].getFiliere().getId()== filiere[i].getId())
//				{
//					System.out.println(etudiant[i]);
//				}
//			}		
//		}
		
		System.out.println("==============================================");
		
		for (Filiere fil: filiere )
		{
			//System.out.println(fil.getLibelle()+ " ");
			for (Etudiant etu : etudiant)
			{
				if (etu.getFiliere().getId()== fil.getId())
				{
					System.out.println(etu);
				}
			}
		}
		
		System.out.println("=============Exception=================================");
		
		
		int x = 5 ;
		int y = 0;
		try
		{
			System.out.println(x/y);	
		}
		catch (ArithmeticException e)
		{
			System.out.println("Division "+e.getMessage());
		}
		System.out.println("fin de calcul");
		

	}

}
