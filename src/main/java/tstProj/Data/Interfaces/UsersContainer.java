package tstProj.Data.Interfaces;

import java.util.List;

import tstProj.Data.Entities.Users;

public interface UsersContainer {
	
	public Users GetById (long ID);	
	
	public Users GetByUserName (String n);
	
	public void Save (Users u);
	
	public void Update (Users u);
	
	public void SaveAll (List<Users> l);
	
	public void Delete (Users u);
	
	public Boolean CheckUsrPwd (String userName, String password);
}
