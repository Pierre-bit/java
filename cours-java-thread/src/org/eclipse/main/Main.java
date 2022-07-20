package org.eclipse.main;

import org.eclipse.classes.Compte;
import org.eclipse.classes.Compteur;
import org.eclipse.classes.JobSylvieEtBruno;
import org.eclipse.classes.MyCount;
import org.eclipse.classes.MyThread;
import org.eclipse.classes.MyThreadRunnable;
import org.eclipse.classes.TestThread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyThread A = new MyThread("A");
		MyThread B = new MyThread("B");
		MyThread C = new MyThread("C");
//		
//		A.start();
//		B.start();
//		C.start();
		
//		Thread A = new Thread(new MyThreadRunnable("A"));
//		Thread B = new Thread(new MyThreadRunnable("B"));
//		Thread C = new Thread(new MyThreadRunnable("C"));
		System.out.println(A.isAlive() + " "+ A.getState());
		
		A.start();
		
		System.out.println(A.isAlive() + " "+ A.getState());
		
		B.start();
		C.start();
		
		// demander  a un thread d'interrompre son execution
		B.interrupt();
		
		// join : bloque le thread courant jusqu'a la mort du thread appelant 
		A.join();
		B.join();
		C.join();
		
		System.out.println(A.isAlive() + " "+ A.getState());
		
		System.out.println(Thread.currentThread().getName()  + " : j'ai fini");
		
		
		// Ecrire une classe Compteur qui herite de Thread avec un attribut nom
		
				// Un compteur a une methode run qui compte de 1 a 7 A chaque iteration, 
				// le thread affiche son nom + l’indice de son iteration
				// puis appelle la methode sleep pour une duree aleatoire (de 0 a 3 000 millisecondes).
				
				// Quand il finit de compter, il affiche un message contenant son
				// nom et un message du type a fini de compter en position x et il affiche sa position
				// Creer un main avec 5 threads et verifier l’execution
		
//		MyThread D = new MyThread("D");
//		MyThread E = new MyThread("E");
//		MyThread F = new MyThread("F");
//		MyThread G = new MyThread("G");
//		MyThread H = new MyThread("H");
//		
//		D.start();
//		E.start();
//		F.start();
//		G.start();
//		H.start();
		
//		Compteur[] compteurs = { new Compteur("a"), new Compteur("b"), new Compteur("c"), new Compteur("d"),
//				new Compteur("e") };
//		for (int i = 0; i < compteurs.length; i++) {
//			compteurs[i].start();
//		}
//		
		
		System.out.println("=================================================================");
//		Thread.currentThread().sleep(1000);
//		System.out.println(Thread.currentThread().getName() +" a fini de compter en position x "+Thread.currentThread().getState());
		
//		MyCount TC = new MyCount();
//		Thread t1 = new Thread(new TestThread(TC," t1 "));
//		Thread t2 = new Thread(new TestThread(TC," t2 "));
//		Thread t3 = new Thread(new TestThread(TC," t3"));
//		t1.start();
//		t2.start();
//		t3.start();
		
		System.out.println("=================================================================");
		
		Compte c1 = new Compte();
		Thread sylvie = new Thread(new JobSylvieEtBruno(c1,"sylvie"));
		Thread bruno = new Thread(new JobSylvieEtBruno(c1,"bruno"));
		
		sylvie.start();
		bruno.start();
	}

}
