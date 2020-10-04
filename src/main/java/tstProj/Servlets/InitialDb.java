package tstProj.Servlets;

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

public class InitialDb extends HttpServlet {

	public InitialDb () {
		
		BooksContainer books = BooksContainerList.GetInstance();
    	BooksTypesContainer booksTypes = BooksTypesContainerList.GetInstance();
    	UsersContainer users = UsersContainerList.GetInstance();
    	
    	String userName = "stranger";
    	users.Save(new Users(userName, "vrempass", "C:\\books\\stranger", 1986));
    	booksTypes.Save(new BooksTypes(MyConstants.BookType1));
    	booksTypes.Save(new BooksTypes(MyConstants.BookType2));
    	books.Save(new Books("Я, любимый"
    			, "tstProj"
    			, 2020
    			, booksTypes.GetByBookType(MyConstants.BookType1)
    			, users.GetByUserName(userName)));
	}
}
