package fr.epita.person.launcher;

import java.util.List;

import fr.epita.person.datamodel.Person;
import fr.epita.person.service.PersonCSVDAO;

public class Launcher {

	
	public static void main(String[] args) throws Exception{
		
		//1 - data initialization
		Person person1 = new Person(180.0, 33, "someone@epita.fr");
		
		PersonCSVDAO dao = new PersonCSVDAO();
		
		dao.create(person1);
		
		List<Person> persons = dao.readAll();
		Person person2 = persons.get(persons.size()-1);
		
		boolean isEmailEqual = person1.getEmail().equals(person2.getEmail());
		boolean isAgeEqual = person1.getAge().equals(person2.getAge());
		boolean isHeightEqual = person1.getHeight().equals(person2.getHeight());
		if (isEmailEqual
			&& isAgeEqual
			&& isHeightEqual){
			System.out.println("comparison success");
			System.out.println("person1: " + person1);
			System.out.println("person2: " + person2);
			
			
		}else {
			System.out.println("person1: " + person1);
			System.out.println("person2: " + person2);
			System.out.println("problem in comparison");
		}
		
	}
}
