package tstProj.Data.Containers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import tstProj.Data.Entities.BooksTypes;
import tstProj.Data.Interfaces.BooksTypesContainer;

public class BooksTypesContainerDb implements BooksTypesContainer{

	//@PersistenceContext(unitName = "persistenceUnit")
    //private EntityManager _em;
	
	private EntityManager getEntityManager () {
		var entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    	var _em = entityManagerFactory.createEntityManager();
    	return _em;
	}
	
	@Override
	public BooksTypes GetById(Integer ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooksTypes GetByBookType(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Save(BooksTypes bt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(BooksTypes bt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SaveAll(List<BooksTypes> l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(BooksTypes bt) {
		// TODO Auto-generated method stub
		
	}

}
