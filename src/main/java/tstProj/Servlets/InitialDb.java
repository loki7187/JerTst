package tstProj.Servlets;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;

import tstProj.Constants.MyConstants;
import tstProj.Data.Containers.BooksContainerList;
import tstProj.Data.Containers.BooksTypesContainerList;
import tstProj.Data.Containers.UsersContainerList;
import tstProj.Data.Entities.Books;
import tstProj.Data.Entities.BooksTypes;
import tstProj.Data.Entities.Users;
import tstProj.Data.Interfaces.BooksContainer;
import tstProj.Data.Interfaces.BooksTypesContainer;
import tstProj.Data.Interfaces.UsersContainer;
import tstProj.Other.Books1;

public class InitialDb extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7427410185421697295L;
	public static final BooksContainer books = BooksContainerList.GetInstance();
	public static final BooksTypesContainer booksTypes = BooksTypesContainerList.GetInstance();
	public static final UsersContainer users = UsersContainerList.GetInstance();

	public InitialDb () {
    	
    	String userName = "stranger";
    	var usr = new Users(userName, "vrempass", "C:\\books\\stranger", 1986);
    	var booksType1 = new BooksTypes(MyConstants.BookType1);
    	var booksType2 = new BooksTypes(MyConstants.BookType2);
    	users.Save(usr);
    	booksTypes.Save(booksType1);
    	booksTypes.Save(booksType2);
    	var b1 = new Books("Я, любимый"
    			, "tstProj"
    			, 2020
    			, booksTypes.GetByBookType(MyConstants.BookType1)
    			, users.GetByUserName(userName));
    	var b2 = new Books("NoOne"
    			, "Дивный новый мир"
    			, 2019
    			, booksTypes.GetByBookType(MyConstants.BookType1)
    			, users.GetByUserName(userName));
    	books.Save(b1);
    	books.Save(b2);
    	
    	var em = getEm();
    	
    	em.getTransaction().begin();
    	em.persist(usr);
    	em.getTransaction().commit();
    	
    	em.getTransaction().begin();
    	em.persist(booksType1);
    	em.persist(booksType2);
    	em.getTransaction().commit();
    	
    	em.getTransaction().begin();
    	em.persist(b1);
    	em.persist(b2);
    	em.getTransaction().commit();
    	em.close();
	}
	
	public static EntityManager getEm () {
		var entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
    	var em = entityManagerFactory.createEntityManager();
    	return em;
	}
}
















