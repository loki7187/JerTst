package tstProj.Data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Books")
@XmlRootElement
public class Books implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5820226182384572526L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer ID;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "year")
	private Integer year;
	
	@JoinColumn(name = "type", referencedColumnName = "ID")
	@ManyToOne
	private BooksTypes type;

	@JoinColumn(name = "usr", referencedColumnName = "ID")
	@ManyToOne
	private Users usr;

	public Books() {
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

	@Override
	public boolean equals(Object obj) {
		Books other = (Books)obj;
		return this.getID() == other.getID();
	}

	@Override
	public int hashCode() {
        return ID.hashCode();
	}
}
