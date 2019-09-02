package com.ModelDao.coreJavanHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.entitiesorPOJO.coreJavanHibernate.StudentDetails;
import com.jdbc.test.connection.coreJavanHibernate.HibernateSessionFactory;

public class StudentDetailsDao implements SearchDao<StudentDetails> {
	
	private Session session;
	private List<StudentDetails> studentDetails;
	
	public StudentDetailsDao(){
	      studentDetails = new ArrayList<StudentDetails>();
	}

	@Override
	public List<StudentDetails> findByColumnEntry(String programName) {
		studentDetails.clear();
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();	
			session.beginTransaction();
			
			studentDetails =   session
					.createQuery("from StudentDetails s where s.degreeProg = '"+programName+"'")
					.getResultList();
			
			studentDetails.forEach(session::delete);

			session.getTransaction().commit();
		 }catch (HibernateException e) {
				 e.printStackTrace();
	    }finally{
	    	session.close();		
		}
		return studentDetails;
	}

	@Override
	public List<StudentDetails> findByEitherColumnsEntry(String entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDetails> findByPatternSearch(String entry) {
		// TODO Auto-generated method stub
		return null;
	}

}
