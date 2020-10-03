package tstProj.Data.Containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tstProj.Data.Entities.BooksTypes;
import tstProj.Data.Interfaces.BooksTypesContainer;

public class BooksTypesContainerList implements BooksTypesContainer {
	
	private ArrayList<BooksTypes> l;
	private static final BooksTypesContainerList st = new BooksTypesContainerList();

	public static BooksTypesContainerList GetInstance() {
		return st;

	}
	
	private BooksTypesContainerList() {
		if (l == null) {
			l = new ArrayList<BooksTypes>();
		}
	}

	@Override
	public BooksTypes GetById(long ID) {
		Optional<BooksTypes> ret = null;
		ret = l.stream().filter(e -> (e.getID() == ID) ? true : false).findFirst();
		return ret.get();
	}

	@Override
	public void Save(BooksTypes bt) {
		synchronized (this) {
			l.add(bt);
		}
		
	}

	@Override
	public void Update(BooksTypes bt) {
		l.stream().filter(e -> (e.getID() == bt.getID()) ? true : false).forEach(e -> e = bt);
		
	}

	@Override
	public void SaveAll(List<BooksTypes> lb) {
		lb.forEach(e -> Save(e));
		
	}

	@Override
	public void Delete(BooksTypes bt) {
		l.remove(bt);
		
	}

}                   
