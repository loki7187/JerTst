package tstProj;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import tstProj.Data.Containers.BooksContainerDb;
import tstProj.Data.Containers.UsersContainerDb;
import tstProj.Data.Entities.Books;
import tstProj.Data.Entities.Users;
import tstProj.Data.Interfaces.BooksContainer;
import tstProj.Data.Interfaces.UsersContainer;
import tstProj.Other.Books1;
import tstProj.Servlets.InitialDb;

import java.util.ArrayList;
import java.util.List;

@Path("")
public class UserResource {

	private UsersContainer users;
	private BooksContainer books;
	
	public UserResource () {
		users = InitialDb.users;
		books = InitialDb.books;
	}
	
	@GET
	@Path("checkPwd")
	@Produces("text/plain")
	public String IsPwdValid(@DefaultValue("noPwd") @QueryParam("pwd") String pwd
			,@DefaultValue("stranger") @QueryParam("usrName") String usrName) {
		
		return users.CheckUsrPwd(usrName, pwd)? "yes" : "no";
	}
	
	@GET
	@Path("usrBooks")
	//@Produces("application/json")
	@Produces (MediaType.APPLICATION_JSON)
	public /*JsonObject*/ List<Books> GetUsrBooks (@DefaultValue("stranger") @QueryParam("usrName") String usrName) {
		
		//var builder = Json.createObjectBuilder();
		Users u = users.GetByUserName(usrName);
		ArrayList<Books> usrBooks = null;
		if (u != null) {
			usrBooks = (ArrayList<Books>) books.GetByUsr(u); 
		}
		//usrBooks.stream().forEach(e -> builder.add(e.getAuthor(), e.getName()));
		
		//return builder.build();
		
		return usrBooks;
	}
	
	@GET
	@Path("usrBooks1")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books1> /*String*/ GetUsrBooks1() {
		ArrayList<Books1> l = new ArrayList<Books1>();
		l.add(new Books1());
        /*return "MyBean{" +
        "anyString='" + "ejf" + '\'' +
        ", anyNumber=" + "ehfwkehf" +
        '}';*/
		
		return l;
    }
	
	@GET
	@Path("usrBooks2")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Books> /*String*/ GetUsrBooks2(@DefaultValue("stranger") @QueryParam("usrName") String usrName) {
		ArrayList<Books> l = new ArrayList<Books>();
		BooksContainer books = new BooksContainerDb();
		UsersContainer users = new UsersContainerDb();
		Users u = users.GetByUserName(usrName);
		l = (ArrayList<Books>) books.GetByUsr(u);
		return l;
    }
	
	
}




















