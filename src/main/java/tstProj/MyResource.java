package tstProj;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
    	BooksContainer books = BooksContainerList.GetInstance();
    	BooksTypesContainer booksTypes = BooksTypesContainerList.GetInstance();
    	UsersContainer users = UsersContainerList.GetInstance();
    	
    	String userName = "stranger";
    	users.Save(new Users(userName, "vrempass", "C:\\", 1986));
    	booksTypes.Save(new BooksTypes(MyConstants.BookType1));
    	booksTypes.Save(new BooksTypes(MyConstants.BookType2));
    	books.Save(new Books("Я, любимый"
    			, "tstProj"
    			, 2020
    			, booksTypes.GetByBookType(MyConstants.BookType1)
    			, users.GetByUserName(userName)));
    	
        return "Got it!";
    }
}
