package tstProj.Data.Containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import tstProj.Data.Entities.Books;
import tstProj.Data.Entities.Users;
import tstProj.Data.Interfaces.BooksContainer;

public class BooksContainerList implements BooksContainer {
	private ArrayList<Books> l;
	private static final BooksContainerList st = new BooksContainerList();

	public static BooksContainerList GetInstance() {
		return st;

	}

	private BooksContainerList() {
		if (l == null) {
			l = new ArrayList<Books>();
		}
	}

	@Override
	public Books GetById(long ID) {
		
		Optional<Books> ret = null;
		ret = l.stream().filter(e -> (e.getID() == ID) ? true : false).findFirst();
		return ret.get();
	}

	@Override
	public List<Books> GetByUsr(Users usr) {
		
		return l.stream().filter(e -> (e.getUsr().getID() == usr.getID())? true:false)
				.collect(Collectors.toList());
	}

	@Override
	public void Save(Books b) {
		synchronized (this) {
			l.add(b);
		}
	}

	@Override
	public void Update(Books b) {
		l.stream().filter(e -> (e.getID() == b.getID()) ? true : false).forEach(e -> e = b);

	}

	@Override
	public void SaveAll(List<Books> lb) {
		lb.forEach(e -> Save(e));

	}

	@Override
	public void Delete(Books b) {
		l.remove(b);

	}

}             