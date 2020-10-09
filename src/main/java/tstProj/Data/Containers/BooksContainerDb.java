package tstProj.Data.Containers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import tstProj.Data.Entities.Books;
import tstProj.Data.Entities.Users;
import tstProj.Data.Interfaces.BooksContainer;

public class BooksContainerDb implements BooksContainer{

	//@PersistenceContext(unitName = "persistenceUnit")
    //private EntityManager _em;
	
	private EntityManager getEntityManager () {
		var entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    	var _em = entityManagerFactory.createEntityManager();
    	return _em;
	}
	
	@Override
	public Books GetById(Integer ID) {
		return getEntityManager().find(Books.class, ID);
	}

	@Override
	public List<Books> GetByUsr(Users usr) {
		var l = new ArrayList<Books>();
		var em = getEntityManager ();
		em.getTransaction().begin();
		em.createQuery("select b from Books b where b.usr = :usr", Books.class)
		.setParameter("usr", usr)
		.getResultList().stream().forEach(e->l.add((Books)e));
		em.getTransaction().commit();
		//em.close();
		return l;
	}

	@Override
	public void Save(Books b) {
		getEntityManager().persist(b);
		
	}

	@Override
	public void Update(Books b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SaveAll(List<Books> l) {
		l.forEach(b-> Update(b));
		
	}

	@Override
	public void Delete(Books b) {
		// TODO Auto-generated method stub
		
	}

}
