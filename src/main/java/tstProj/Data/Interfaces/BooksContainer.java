package tstProj.Data.Interfaces;

import java.util.List;

import tstProj.Data.Entities.Books;
import tstProj.Data.Entities.Users;

public interface BooksContainer {
	
	public Books GetById (long ID);
	
	public List<Books> GetByUsr (Users usr);
	
	public void Save (Books b);
	
	public void Update (Books b);
	
	public void SaveAll (List<Books> l);
	
	public void Delete (Books b);
}
