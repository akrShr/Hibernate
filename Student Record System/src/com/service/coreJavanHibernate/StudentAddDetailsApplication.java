package com.service.coreJavanHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ModelDao.coreJavanHibernate.SearchDao;
import com.ModelDao.coreJavanHibernate.StudentDetailsDao;
import com.entitiesorPOJO.coreJavanHibernate.StudentDetails;

public class StudentAddDetailsApplication {
	
	private Scanner scanner;
	private List<StudentDetails> studentDetails;
	private SearchDao<StudentDetails> searchDao;
	
	public StudentAddDetailsApplication() {
		
		scanner = new Scanner(System.in);  // Create a Scanner object	
		studentDetails = new ArrayList<StudentDetails>();
		searchDao = new StudentDetailsDao();
	}

	
	
	public void retrieveStudentonDegreeProgram(){			
			 
			System.out.println("\nEnter the name of the program");
			String prog = scanner.nextLine();
						
			studentDetails = this.searchDao.findByColumnEntry(prog);
			
			System.out.println("Retrieving students record");
			
			studentDetails.forEach((i)->System.out.println("\nFirst Name: "+i.getStudent().getFirstName()+
						"\nLast Name: "+i.getStudent().getLastName()+"\nEmail Address: "+i.getStudent().getEmail()+
						"\nSemester: "+i.getSemester()));
				
			System.out.println("--------------------------");
		}

}
