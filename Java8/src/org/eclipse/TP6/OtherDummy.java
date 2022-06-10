package org.eclipse.TP6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OtherDummy {

	public static void main(String[] args) {

		// exemple 1

		// Fonction anonyme ou on  instance la classe Thread a laquelle 
		// on passe une instance de la classe Runnable
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello 1");
			}
		}).start();

		// expressions lambda
		new Thread(() -> System.out.println("Hello 2")).start();

		// ou
		
		// Fonction anonyme
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello 3");

			}
		};

		Thread t1 = new Thread(r);
		t1.start();
		
		// expressions lambda
		Runnable r2 = () -> System.out.println("Hello 4");
		new Thread(r2).start();

		// exemple 2

		// Declaration et initialisation d'une collection de type String
		List<Machine> machines = Arrays.asList(new Machine(1998, "hhhhh"), new Machine(1987, "hhhhh"),
				new Machine(2017, "hhhhh"));

		// utilisation de la methode statique de la classe Collections pour trier notre liste machines
		// qui prend en argument une liste et une instance de Comparator<T>
		Collections.sort(machines, new SortByYear());

		// Simplification en passant par une methode anonyme
		Comparator<Machine> comp = new Comparator<Machine>() {
			@Override
			public int compare(Machine o1, Machine o2) {
				return o1.getYear() - o2.getYear();
			}
		};
		
		Collections.sort(machines, comp);
		
		// ou en passant par une expression lambda
		Comparator<Machine> comp2 = (o1, o2) -> o1.getYear() - o2.getYear();
					
		Collections.sort(machines, comp2);
		
		// Tri d'une liste a partir de la methode sort(), ici methode d'instance de List<T>
		machines.sort((m1, m2) -> m1.getYear() - m2.getYear());
		
		machines.forEach(System.out::println);

	}
}
