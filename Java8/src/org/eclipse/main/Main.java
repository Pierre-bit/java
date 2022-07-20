package org.eclipse.main;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.eclipse.interfaces.Message;
import org.eclipse.interfaces.ShowText;
import org.eclipse.classes.Text;
import org.eclipse.interfaces.Calcul;

public class Main {

	public static void main(String[] args) {
		
		Calcul addition = (x,y) -> x + y;
		System.out.println("8 + 2 = " +calculer(8,2,addition));
	
		List<String>sports = Arrays.asList("foot","basket","tennis");
		sports.forEach(sport -> System.out.println(sport));
		
		Predicate<Double> function51 = (t) -> t > 10;
		
		System.out.println(function51.test(-20d));
		
		System.out.println(function51.test(Double.valueOf(-15)));
		
		
		Supplier<Double> random = () -> Math.random(); 
		System.out.println("Random value 1 : " + random.get());
		System.out.println("Random value 2 : " + random.get());
		System.out.println("Random value 3 : " + random.get());
		
		Supplier<LocalDateTime> date1 = () -> LocalDateTime.now();
		System.out.println("Date / Heures : " + date1.get());
				
		// Function <T,R> : Operation qui accepte un unique argument (type T) et
		// retourne un resultat		
		Function<String, String> function2 = (value) -> value.toUpperCase();
		Function<String, String> function3 = (value) -> value.toLowerCase();
		
		System.out.println("Value to Uppercase : " + function2.apply("boNjOUr"));
		System.out.println("Value to Lowercase : " + function3.apply("boNjOUr"));
		
		Function<Integer, Integer> function4 = (value) -> ++value;
		
		System.out.println("Integer PreIncrement : " + function4.apply(1));
		
		// Predicate <T> : un paramètre, résultat de type booléen		
		Predicate<Double> function58 = (x) -> x > 10;
	
		
		// BiFunction <T,U,R> : deux paramètres, un résultat
		BiFunction<String, String, String> instead = (param1, param2) -> {
			String a = param1.replace(param2, "b");
			return a;
		};
		
		System.out.println(instead.apply("abcde", "c"));
		
		// reference a une methode de classe static
		Message m1= Main::Message1;
		m1.show();
		
		// reference a une methode d'instance
		Main main = new Main();
		Message m2 = main::Message2;
		m2.show();
		
		// Référence à une méthode non statique à l'aide d'un objet anonyme
		Message m3 = new Main()::Message2;
		m3.show();
		
		System.out.println("==============================");
		
		// Référence à un constructeur
		// référencer un constructeur en utilisant le mot-clé « new »		
		ShowText sText = Text::new;
		sText.getText("Hello from ref constructor");
		
		Text t = new Text();
		t.getText("hello");
	}
	
	private static int calculer(int x, int y, Calcul operation) {
	return operation.calc(x, y);
	}
	
	private static void Message1()
	{
		System.out.println("next message");
	}
	
	private void Message2()
	{
		System.out.println("other message");
	}
}
