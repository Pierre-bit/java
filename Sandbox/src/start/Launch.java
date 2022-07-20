package start;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Animal;
import model.Chat;
import model.Felin;
import model.I;
import model.Poule;


public class Launch  {

	public static void main(String[] args) {
		System.out.println(I.MSG);
		int res = I.add(3, 5);
		
		Math.random();
		
		List<Person> l = new ArrayList<Person>();
		l.add(new Person());
		
		for (Person person : l) {
			
		}

		
//		List<Animal> tlist_animal = new ArrayList<Animal>();
//		tlist_animal.add(new Chat());
//		tlist_animal.add(new Felin());
//		tlist_animal.add(new Poule());
		Animal a = new Chat();
		
		List<Animal> list = List.of(new Animal(),new Felin(),new Poule(),a);
		
		for (Animal animal : list) {
			animal.crie();
		}
	}

}
