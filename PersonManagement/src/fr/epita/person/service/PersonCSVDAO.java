package fr.epita.person.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.epita.person.datamodel.Person;

public class PersonCSVDAO {

	// --> CRUD : Create / Read / Update / Delete
	// ISUD : Insert / Select / Update / Delete

	public void create(Person person) throws FileNotFoundException {
		// 2 - serialization
		// we want to format "person1" as follows
		// 180;33;someone@epita.fr
		String formatted = String.valueOf(person.getHeight()) + ";";
		formatted += String.valueOf(person.getAge()) + ";";
		formatted += person.getEmail();

	

		// 3 - persistence
		//TODO write this line to the file
		PrintWriter writer = new PrintWriter(new FileOutputStream(new File("data.csv"), true));
		writer.println(formatted);
		writer.close();
	}

	public List<Person> readAll() throws IOException {
		
		List<Person> results = new ArrayList<>();
		List<String> lines = Files.readAllLines(new File("data.csv").toPath());
 		
		for (String line : lines) {
			String[] parts = line.split(";");
	
			// String to numeric conversion : Double.valueOf(s)
			// TODO read person2 fields from the formatted String
			Double height = Double.valueOf(parts[0]);
			Integer age = Integer.valueOf(parts[1]);
			String email = parts[2];
			Person currentPerson = new Person(height, age, email);
			results.add(currentPerson);
		}
		return results;
		

	}

}
