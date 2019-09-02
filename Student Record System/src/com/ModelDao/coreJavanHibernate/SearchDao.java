package com.ModelDao.coreJavanHibernate;

import java.util.List;

public interface SearchDao<T> {		
	    
		   List<T> findByColumnEntry(String entry);
		   List<T> findByEitherColumnsEntry(String entry);
		   List<T> findByPatternSearch(String entry);
		   
}
