package tstProj.Data.Containers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Users u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SaveAll(List<Users> l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Users u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean CheckUsrPwd(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
