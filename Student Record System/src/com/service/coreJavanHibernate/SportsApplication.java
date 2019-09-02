package com.service.coreJavanHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ModelDao.coreJavanHibernate.Dao;
import com.ModelDao.coreJavanHibernate.SportsDao;
import com.entitiesorPOJO.coreJavanHibernate.Sports;
import com.entitiesorPOJO.coreJavanHibernate.Student;


public class SportsApplication {
	
	
	private Scanner scanner;
	private List<Sports> sports;
	private Dao<Sports> dao;

	public SportsApplication() {
		scanner = new Scanner(System.in);  // Create a Scanner object	
		sports = new ArrayList<Sports>();
		dao = new SportsDao();
	}
	
	
	public void saveSports(){
		System.out.println("\nPlease enter sports details");
		String choice = "yes";		
		sports.clear();		
				
		while(choice.equalsIgnoreCase("yes"))
		{   Sports sport = new Sports();
		
			System.out.println("Sport's name");
			sport.setTitle(scanner.nextLine());
					
			
			System.out.println("Assign Sport to students?(yes/no)");
			String otherData=scanner.nextLine();
			if(otherData.equalsIgnoreCase("yes")){
				System.out.println("Sports are assigned as per email domain address!!");
				
				StudentApplication stuApp = new StudentApplication();
				stuApp.findByEmailDomain();
				List<Student> students=stuApp.getStudents();
				for(Student stud:students){
					stud.addSports(sport);
				}
				
			}			
						
			sports.add(sport);			
			
			System.out.println("\nWant to enter more Sports?(yes/no)");
			choice=scanner.nextLine();
			
		}
		System.out.println("--------------------------");
		sports.forEach(this.dao::save);
		
	}
	
	public void deleteSportEntry(){
		 System.out.println("\nEnter sports name to be deleted");
		 String name = scanner.nextLine();
		 this.dao.delete(name);
	}
	
	
	
}
