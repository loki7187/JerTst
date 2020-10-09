package tstProj.Data.Containers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
		return getEntityManager().find(BooksTypes.class, ID);
	}

	@Override
	public BooksTypes GetByBookType(String t) {
		var l = new BooksTypes();
		var em = getEntityManager ();
		em.getTransaction().begin();
		l = em.createQuery("select b from BooksTypes b where b.typeName = :typeName", BooksTypes.class)
		.setParameter("typeName", t)
		.getSingleResult();
		em.getTransaction().commit();
		//em.close();
		return l;
	}

	@Override
	public void Save(BooksTypes bt) {
		getEntityManager().persist(bt);
		
	}

	@Override
	public void Update(BooksTypes bt) {
		getEntityManager().merge(bt);
		
	}

	@Override
	public void SaveAll(List<BooksTypes> l) {
		l.forEach(b-> Update(b));
		
	}

	@Override
	public void Delete(BooksTypes bt) {
		var em = getEntityManager();
		em.remove(em.merge(bt));
		
	}

}
