package org.eclipse.classes;

public class JobSylvieEtBruno implements Runnable {

	private Compte compte;
	private String name;
	
	public JobSylvieEtBruno() {
		// TODO Auto-generated constructor stub
	}
	
	public JobSylvieEtBruno(Compte compte, String name) {
		super();
		this.compte = compte;
		this.name = name;
	}



	public void effectuerRetrait(int montant)
	{
		System.out.println("solde du compte" + compte.getSolde() );
		synchronized(compte)
		{
			if (compte.getSolde()>=montant)
			{
				try {
					
					System.out.println(name+" s' endort" );
					Thread.sleep(500);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name+" se reveille" );
				compte.retraitArgent(10);
				System.out.println("Operation reussie demandee par " + name);
			}
			else
			{
				System.out.println("Echec de l'operation de retrait par "+name);
			}
				
		}
	}
	
	public void run()
	{
		for (int i = 0 ; i<10; i++)
		{
			effectuerRetrait(10);	
		}
	}
}
