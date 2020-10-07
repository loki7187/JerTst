package tstProj.Data.Interfaces;

import java.util.List;

import tstProj.Data.Entities.BooksTypes;

public interface BooksTypesContainer {
	
	public BooksTypes GetById(Integer ID);
	
	public BooksTypes GetByBookType (String t);

	public void Save(BooksTypes bt);

	public void Update(BooksTypes bt);

	public void SaveAll(List<BooksTypes> l);

	public void Delete(BooksTypes bt);
}
