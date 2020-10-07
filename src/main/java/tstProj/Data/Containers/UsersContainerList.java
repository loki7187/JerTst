package tstProj.Data.Containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tstProj.Data.Entities.Users;
import tstProj.Data.Interfaces.UsersContainer;

public class UsersContainerList implements UsersContainer {

	private ArrayList<Users> l;
	private static final UsersContainerList st = new UsersContainerList();

	public static UsersContainerList GetInstance() {
		return st;

	}

	private UsersContainerList() {
		if (l == null) {
			l = new ArrayList<Users>();
		}
	}

	@Override
	public Users GetById(Integer ID) {
		Optional<Users> ret = null;
		ret = l.stream().filter(e -> (e.getID() == ID) ? true : false).findFirst();
		return ret.get();
	}

	@Override
	public void Save(Users u) {
		synchronized (this) {
			l.add(u);
		}

	}

	@Override
	public void Update(Users u) {
		l.stream().filter(e -> (e.getID() == u.getID()) ? true : false).forEach(e -> e = u);

	}

	@Override
	public void SaveAll(List<Users> lb) {
		lb.forEach(e -> Save(e));

	}

	@Override
	public void Delete(Users u) {
		l.remove(u);

	}

	@Override
	public Boolean CheckUsrPwd(String userName, String password) {
		Optional<Users> usr = l.stream().filter(e -> e.getUserName().equals(userName) ? true : false).findFirst();
		return usr.get().getPassword().equals(password);
	}

	public Users GetByUserName(String n) {
		Optional<Users> ret = null;
		ret = l.stream().filter(e -> (e.getUserName().equals(n)) ? true : false).findFirst();
		return ret.get();
	}
}
