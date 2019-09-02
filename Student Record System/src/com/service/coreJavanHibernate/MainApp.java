package com.service.coreJavanHibernate;

public class MainApp {

	public static void main(String[] args) {			   
			
			StudentApplication application = new StudentApplication();
			StudentAddDetailsApplication addApplication =new StudentAddDetailsApplication();
			SportsApplication sportApplication= new SportsApplication();
			
			
			
			//CRUD Operations
			application.saveStudentDetails();
			addApplication.retrieveStudentonDegreeProgram();
			application.retrieveAllStudentDetails();
	
			application.saveStudentDetails();
			application.retrieveStudentDetails();			
			application.admitStudentonAddmisionWait();
			application.deleteStudentEntry();
			application.retrieveAllStudentDetails();
			
			//Delete a Sport
			sportApplication.deleteSportEntry();
			
			
			//Search Query Operations
		
			application.findByLastName();
			application.findByEmailDomain();
			application.findByFirstNameorLastName();
			
			
			//To close all connections with Student Application
			
			 application.closeApplication();
			
			
	

	}

}
