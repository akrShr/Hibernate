package com.ModelDao.coreJavanHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.entitiesorPOJO.coreJavanHibernate.Sports;
import com.jdbc.test.connection.coreJavanHibernate.HibernateSessionFactory;

public class SportsDao implements Dao<Sports> {
	
	private Session session;
	private List<Sports> sports;
	
	public SportsDao() {
		sports = new ArrayList<Sports>();
		}

		@Override
	public Sports get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sports> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Sports sport) {
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();
			session.beginTransaction();
			session.save(sport);
			session.getTransaction().commit();
			 }catch (HibernateException e) {
				 e.printStackTrace();
        }finally{
        	session.close();
        	
        }

	}

	@Override
	public List<Sports> update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String title) {
		
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();	
			session.beginTransaction();	
			sports =   session
					.createQuery("from Sports s where s.title = '"+title+"'")
					.getResultList();
			sports.forEach(session::delete);
			session.getTransaction().commit();
		 }catch (HibernateException e) {
				 e.printStackTrace();
	    }finally{
	    	session.close();		
		}
		
	}

	

}
