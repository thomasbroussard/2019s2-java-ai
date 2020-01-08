package fr.epita.person.launcher;

import fr.epita.person.datamodel.Person;

public class Launcher {

	
	public static void main(String[] args) {
		Person person1 = new Person(180.0, 33, "someone@epita.fr");
		
		
		//we want to format "person1" as follows
		//180;33;someone@epita.fr
		String formatted = String.valueOf(person1.getHeight()) + ";";
		formatted += String.valueOf(person1.getAge()) + ";";
		formatted += person1.getEmail();
		
		System.out.println(formatted);
		
		//TODO read person2 fields from the formatted String
		
		Person person2 = new Person(height, age, email);
		
	}
}
