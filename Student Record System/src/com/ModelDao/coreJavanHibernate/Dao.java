package com.ModelDao.coreJavanHibernate;

import java.util.List;

import com.jdbc.test.connection.coreJavanHibernate.HibernateSessionFactory;


public interface Dao<T> {
    
   T get(int id);
    
   List<T> getAll();
    
   void save(T t);
    
   List<T> update();

    
   void delete(String property);
   
   default void close(){
	   HibernateSessionFactory.closeFactory();
   }
}