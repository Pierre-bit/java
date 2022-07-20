package org.eclipse.classes;

public class Compteur extends Thread{

	
	private String name;
	private static int ordre = 1;
	
	public Compteur() {
	}

	public Compteur(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 7; i++) {
			System.out.print(name + " " +i);
			try {
				sleep((long)Math.random()*3000);
			}
			catch (InterruptedException e) {
				System.err.println(name + " a ete interrompu.");
			}
		}
		System.out.println(name + " a fini de compter en position " + ordre++);
		}

}
