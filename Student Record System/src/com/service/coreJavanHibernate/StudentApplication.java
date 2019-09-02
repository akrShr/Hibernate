package com.service.coreJavanHibernate;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ModelDao.coreJavanHibernate.Dao;
import com.ModelDao.coreJavanHibernate.SearchDao;
import com.ModelDao.coreJavanHibernate.StudentDao;
import com.entitiesorPOJO.coreJavanHibernate.Student;
import com.entitiesorPOJO.coreJavanHibernate.StudentDetails;


public class StudentApplication {
	
	private Scanner scanner;
	private List<Student> students;
	public List<Student> getStudents() {
		return students;
	}

	private Dao<Student> dao;
	private SearchDao<Student> searchDao;
	
	
	 StudentApplication(){
		scanner = new Scanner(System.in);  // Create a Scanner object	
		students = new ArrayList<Student>();
		dao = new StudentDao();
		searchDao = new StudentDao();
		}
	
	public void saveStudentDetails(){
		System.out.println("\nPlease enter student details");
		String choice = "yes";		
		students.clear();
		
		while(choice.equalsIgnoreCase("yes"))
		{   Student student = new Student();
		
			System.out.println("First name");
			student.setFirstName(scanner.nextLine());
			
			System.out.println("Last name");
			student.setLastName(scanner.nextLine());
			
			System.out.println("Email Address");
			student.setEmail(scanner.nextLine());
			
			student.setAddmisionStatus("Waiting");
			
			StudentDetails studentDetails = new StudentDetails();
			System.out.println("Enter Additional Information?(yes/no)");
			String otherData=scanner.nextLine();
			if(otherData.equalsIgnoreCase("yes")){
				System.out.println("Degree Program");
				studentDetails.setDegreeProg(scanner.nextLine());
				
				System.out.println("Semester");
				studentDetails.setSemester(scanner.nextLine());
			}
				
			student.setStudentDetails(studentDetails);
			
			students.add(student);
			
			
			System.out.println("Want to enter more records?(yes/no)");
			choice=scanner.nextLine();
			
		}
		System.out.println("--------------------------");
		students.forEach(this.dao::save);
	}
	
	public void retrieveStudentDetails(){
		System.out.println("\nRetrieving students record");
		String choice = "yes";		
				
		while(choice.equalsIgnoreCase("yes"))		{   
			System.out.println("Enter the student id");
			int id = Integer.parseInt(scanner.nextLine());
			
			Student student = this.dao.get(id);
					
			System.out.println("\nFirst Name: "+student.getFirstName()+
 					"\nLast Name: "+student.getLastName()+"\nEmail Address: "+student.getEmail()
 					+"\nDegree Program: "+student.getStudentDetails().getDegreeProg()
 					 +"\nSemester: "+student.getStudentDetails().getSemester());

			System.out.println("Want to display more records?(yes/no)");
			choice=scanner.nextLine();
		}
		System.out.println("--------------------------");
		}
	
	 public void retrieveAllStudentDetails(){
		 students.clear();
		 students = this.dao.getAll();		
		 System.out.println("\nDisplaying all the student's record");
		 students.forEach((i)->System.out.println("\nFirst Name: "+i.getFirstName()+
					"\nLast Name: "+i.getLastName()+"\nEmail Address: "+i.getEmail()+
					"\nDegree Program: "+i.getStudentDetails().getDegreeProg()+
					"\nSemester: "+i.getStudentDetails().getSemester()
					));

					
		 
	 }
	
	public void findByLastName(){
		 students.clear();
		 System.out.println("\nEnter Last name");
		 String lastName = scanner.nextLine();
		 students = this.searchDao.findByColumnEntry(lastName);
		 System.out.println("Retrieving records");
		 students.forEach((i)->System.out.println("\nFirst Name: "+i.getFirstName()+
					"\nLast Name: "+i.getLastName()+"\nEmail Address: "+i.getEmail()));
	}
	
	public void findByEmailDomain(){
		 students.clear();
		 System.out.println("\nEnter email domain");
		 String domain = scanner.nextLine();
		 students = this.searchDao.findByPatternSearch(domain);
		 System.out.println("Retrieving records");
		 students.forEach((i)->System.out.println("\nFirst Name: "+i.getFirstName()+
					"\nLast Name: "+i.getLastName()+"\nEmail Address: "+i.getEmail()));
	}
	
	public void findByFirstNameorLastName(){
		 students.clear();
		 System.out.println("\nEnter the text for name search");
		 String name = scanner.nextLine();
		 students = this.searchDao.findByEitherColumnsEntry(name);
		 System.out.println("Retrieving records");
		 students.forEach((i)->System.out.println("\nFirst Name: "+i.getFirstName()+
					"\nLast Name: "+i.getLastName()+"\nEmail Address: "+i.getEmail()));
	}
	
	public void admitStudentonAddmisionWait(){
		students.clear();
		students = this.dao.update();
		System.out.println("\nRecently admitted student's record");
		students.forEach((i)->System.out.println("\nFirst Name: "+i.getFirstName()+
					"\nLast Name: "+i.getLastName()+"\nEmail Address: "+i.getEmail()));
	}
	
	public void deleteStudentEntry(){
		 System.out.println("\nEnter text whose record to be deleted");
		 String name = scanner.nextLine();
		 this.dao.delete(name);
	}
	
	
	
	public void closeApplication(){
		this.dao.close();
	}
	
}
