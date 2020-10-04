package tstProj;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tstProj.Data.Containers.BooksContainerList;
import tstProj.Data.Containers.UsersContainerList;
import tstProj.Data.Entities.Books;
import tstProj.Data.Entities.Users;
import tstProj.Data.Interfaces.BooksContainer;
import tstProj.Data.Interfaces.UsersContainer;

import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;

@Path("usr")
public class UserResource {

	private UsersContainer users;
	private BooksContainer books;
	
	public UserResource () {
		users = UsersContainerList.GetInstance();
		books = BooksContainerList.GetInstance();
	}
	
	@GET
	@Path("checkPwd")
	@Produces("text/plain")
	public String IsPwdValid(@DefaultValue("noPwd") @QueryParam("pwd") String pwd
			,@DefaultValue("stranger") @QueryParam("usrName") String usrName) {
		
		
		Users u = users.GetByUserName(usrName);
		String res = "no";
		if (u != null) {
			if (u.getPassword().equals(pwd)) {
				res = "yes";
			}
		}
		return res;
	}
	
	@GET
	@Path("usrBooks")
	@Produces("application/json")
	public /*JsonObject*/ ArrayList<Books> GetUsrBooks (@DefaultValue("stranger") @QueryParam("usrName") String usrName) {
		
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
}

















