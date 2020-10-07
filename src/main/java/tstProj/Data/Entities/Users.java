package tstProj.Data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Users")
@XmlRootElement
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6366500008314320610L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer ID;
	
	@Column(name = "userName", unique = true)
	private  String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "avaPath")
	private String avaPath;
	
	@Column(name = "yearOfBirth")
	private Integer yearOfBirth;

	public Users() {
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

	@Override
	public boolean equals(Object obj) {
		Users other = (Users) obj;
		return this.getID() == other.getID();
	}

	@Override
	public int hashCode() {
        return ID.hashCode();
	}
}
