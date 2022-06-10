package org.eclipse.TP6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Inside : " + Thread.currentThread().getName());
			}});
		thread.start();
		
		//2eme version 
		
		// fonction anonyme de la classe Thread a laquelle on associe fonction anonyme de la classe Runnable
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		}).start();
		
		// expression lambda
		new Thread(() -> System.out.println("Inside : " + Thread.currentThread().getName())).start();
		
		
		System.out.println("=============================================");
		
		
		Machine o1= new Machine(2015,"fiat");
		Machine o2= new Machine(2008,"Peugeot");
		Machine mac1[] = new Machine[] {o1, o2};
		List<Machine> list = Arrays.asList(mac1);
		
		List<Machine> machine = Arrays.asList(new Machine(2015,"fiat"),new Machine(2008,"Peugeot"));
		
		
		// Sans expressions lambda 
		Collections.sort(list,new Comparator<Machine>() {
			@Override
			public int compare(Machine o1, Machine o2) {
				// TODO Auto-generated method stub
				return o1.getYear() - o2.getYear();
			}
		});
		
		// expression lambda
		list.sort(Comparator.comparing(Machine::getYear));
		System.out.println(list);
		
		System.out.println("=============================================");
		
		machine.sort((m1,m2) -> m1.getYear() - m2.getYear());
		machine.forEach(System.out::println);
	}
		
}
