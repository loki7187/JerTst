package tstProj.Data.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Books {
	private @Id @GeneratedValue long ID;
	private String author;
	private String name;
	private Integer year;
	@ManyToOne
	private BooksTypes type;
	@ManyToOne
	private Users usr;

	private Books() {
	};

	public Books(String author, String name, Integer year, BooksTypes type, Users usr) {
		setAuthor(author);
		setName(name);
		setYear(year);
		setType(type);
		setUsr(usr);

	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public BooksTypes getType() {
		return type;
	}

	public void setType(BooksTypes type) {
		this.type = type;
	}

	public Users getUsr() {
		return usr;
	}

	public void setUsr(Users usr) {
		this.usr = usr;
	}
	public long getID() {
		return ID;
	}
}
