package com.jdbc.test.connection.coreJavanHibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entitiesorPOJO.coreJavanHibernate.Sports;
import com.entitiesorPOJO.coreJavanHibernate.Student;
import com.entitiesorPOJO.coreJavanHibernate.StudentDetails;

public final class HibernateSessionFactory  {
	
	// static variable single_instance of type Singleton 
    private static HibernateSessionFactory single_instance = null;
    private SessionFactory factory;

    // private constructor restricted to this class itself 
    private HibernateSessionFactory() 
    { 
       factory = (SessionFactory) new Configuration()
       							.configure()
       							.addAnnotatedClass(Student.class)
       							.addAnnotatedClass(StudentDetails.class)
       							.addAnnotatedClass(Sports.class)
       							.buildSessionFactory();
    } 
    
    
    // static method to create instance of Singleton class 
    public static SessionFactory getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new HibernateSessionFactory(); 
  
        return single_instance.factory; 
    } 
    

    public static void closeFactory() {
        if (single_instance.factory != null) {
            try {
            	single_instance.factory.close();
            } catch (HibernateException exception) {
            	exception.printStackTrace();    
            }
        }
    }

  
}
