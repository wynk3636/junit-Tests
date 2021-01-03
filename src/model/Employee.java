package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getEmail() {
		return this.email;
	}

	public static List<Employee> load(InputStream input) {
		LinkedList<Employee> list = new LinkedList<Employee>();
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(input));){
			
			for(;;) {
				String line = reader.readLine();
				if(line==null) break;
				
				String[] values = line.split(",");
				Employee emp = new Employee(values[0], values[1], values[2]);
				list.add(emp);
			}
			return list;
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

}
