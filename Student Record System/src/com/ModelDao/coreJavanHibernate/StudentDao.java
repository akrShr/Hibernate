package com.ModelDao.coreJavanHibernate;

import java.util.ArrayList;
import java.util.List;




import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.entitiesorPOJO.coreJavanHibernate.Student;
import com.jdbc.test.connection.coreJavanHibernate.HibernateSessionFactory;

public class StudentDao implements Dao<Student>, SearchDao<Student>{
	
	private Session session;
	private List<Student> students;
	
	public StudentDao(){
	      students = new ArrayList<Student>();
	}
	
	@Override
	public Student get(int id) {
		students.clear();		
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();
			session.beginTransaction();
			students.add(session.get(Student.class,id));
			session.getTransaction().commit();
		   }catch (HibernateException e) {
				e.printStackTrace();
			}finally{
	        	session.close();	        	
	        }
		return students.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		students.clear();	
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();	
			session.beginTransaction();
			students = session.createQuery("from Student").getResultList();
			session.getTransaction().commit();
		 }catch (HibernateException e) {
			 e.printStackTrace();
    }finally{
    	session.close();		
	}
		return students;
	}

	@Override
	public void save(Student student) {		
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			 }catch (HibernateException e) {
				 e.printStackTrace();
        }finally{
        	session.close();
        	
        }
	}


	@Override
	public List<Student> update() {
		students.clear();	
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();	
			session.beginTransaction();
			students = session.createQuery("from Student s where s.addmisionStatus = 'Waiting'")
					.getResultList();
			session.createQuery("update Student set addmisionStatus = 'Admitted'").executeUpdate();
			
			session.getTransaction().commit();
			 
			}catch (HibernateException e) {
				 e.printStackTrace();
		    }finally{
		    	session.close();		
			}
		
		return students;
		
	}

	@Override
	public void delete(String name) {
		students = findByEitherColumnsEntry(name);
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();	
			session.beginTransaction();			
			students.forEach(session::delete);
			session.getTransaction().commit();
		 }catch (HibernateException e) {
				 e.printStackTrace();
	    }finally{
	    	session.close();		
		}
	}	

	@Override
	public List<Student> findByColumnEntry(String lastName) {
		students.clear();
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();	
			session.beginTransaction();
			
			students =   session
					.createQuery("from Student s where s.lastName = '"+lastName+"'")
					.getResultList();

			session.getTransaction().commit();
		 }catch (HibernateException e) {
				 e.printStackTrace();
	    }finally{
	    	session.close();		
		}
		return students;
	}

	@Override
	public List<Student> findByEitherColumnsEntry(String name) {
		students.clear();
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();	
			session.beginTransaction();
					
			Query query = session.createQuery("from Student s where s.lastName = :name OR s.firstName = :name");
			query.setParameter("name", name);			
			students = query.getResultList();
			
			/*students =   session
						.createQuery("from Student s where s.lastName = '"+name+"' OR s.firstName = '"+name+"'")
					    .getResultList();*/
			
			session.getTransaction().commit();
		 }catch (HibernateException e) {
				 e.printStackTrace();
	    }finally{
	    	session.close();		
		}
		return students;
	}

	@Override
	public List<Student> findByPatternSearch(String email) {
		students.clear();
		try{
			session = HibernateSessionFactory.getInstance().getCurrentSession();	
			session.beginTransaction();
			
			students =   session
						.createQuery("from Student s where s.email LIKE '%"+email+"'")
					    .getResultList();
			
			session.getTransaction().commit();
		 }catch (HibernateException e) {
				 e.printStackTrace();
	    }finally{
	    	session.close();		
		}
		return students;
	}

	
	
	
}
