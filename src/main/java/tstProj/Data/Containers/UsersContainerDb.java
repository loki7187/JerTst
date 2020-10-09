package tstProj.Data.Containers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import tstProj.Data.Entities.Users;
import tstProj.Data.Interfaces.UsersContainer;

public class UsersContainerDb implements UsersContainer {

	//@PersistenceContext(unitName = "persistenceUnit")
    //private EntityManager _em;
	
	private EntityManager getEntityManager () {
		var entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    	var _em = entityManagerFactory.createEntityManager();
    	return _em;
	}
	
	@Override
	public Users GetById(Integer ID) {
		return getEntityManager().find(Users.class, ID);
	}

	@Override
	public Users GetByUserName(String n) {
		var em = getEntityManager ();
		em.getTransaction().begin();
		var u = em.createQuery("select u from Users u where u.userName = :userName", Users.class)
		.setParameter("userName", n)
		.getSingleResult();
		em.getTransaction().commit();
		//em.close();
		return u;
	}

	@Override
	public void Save(Users u) {
		getEntityManager().persist(u);
		
	}

	@Override
	public void Update(Users u) {
		getEntityManager().merge(u);
		
	}

	@Override
	public void SaveAll(List<Users> l) {
		l.forEach(b-> Update(b));
		
	}

	@Override
	public void Delete(Users u) {
		var em = getEntityManager();
		em.remove(em.merge(u));
		
	}

	@Override
	public Boolean CheckUsrPwd(String userName, String password) {
		return (Boolean)GetByUserName(userName).getPassword().equals(password);
	}

}
