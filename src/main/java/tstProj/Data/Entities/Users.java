package tstProj.Data.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Users {
	private @Id @GeneratedValue long ID;
	private @Column(unique = true) String userName;
	private String password;
	private String avaPath;
	private Integer yearOfBirth;

	private Users() {
	};

	public Users(String userName, String password, String avaPath, Integer yearOfBirth) {
		this.avaPath = avaPath;
		setPassword(password);
		setUserName(userName);
		setYearOfBirth(yearOfBirth);
	}

	public String getAvaPath() {
		return avaPath;
	}

	public long getID() {
		return ID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setAvaPath(String avaPath) {
		this.avaPath = avaPath;
	}

	public String getPassword() {
		return password;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}
}
