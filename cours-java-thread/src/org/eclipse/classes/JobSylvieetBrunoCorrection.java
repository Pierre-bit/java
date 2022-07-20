package org.eclipse.classes;

public class JobSylvieetBrunoCorrection {

	private Compte compte;
	private String name;

	public void run() {
		for (int x = 0; x < 10; x++) {
			effectuerRetrait(10);
		}
	}
	public JobSylvieetBrunoCorrection() {
	}
	public JobSylvieetBrunoCorrection(Compte compte, String name) {
		super();
		this.compte = compte;
		this.name = name;
	}
	private void effectuerRetrait(int montant) {
		synchronized (compte) {
			if (compte.getSolde() > montant) {
				System.out.println(this.name + " va retirer");
				try {
					System.out.println(this.name + " va dormir");
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.name + " se reveille");
				compte.retraitArgent(10);
				System.out.println(this.name + " retrait fait");
			} else {
				System.out.println(this.name + " pas assez");
			}
		}
	}

}
