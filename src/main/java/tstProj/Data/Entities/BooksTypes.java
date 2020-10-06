package tstProj.Data.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BooksTypes {
	
	private @Id @GeneratedValue long ID;
	private String typeName;

	public BooksTypes() {
	}

	public BooksTypes(String typeName) {
		setTypeName(typeName);
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public long getID() {
		return ID;
	}
	
	@Override
	public boolean equals(Object obj) {
		BooksTypes other = (BooksTypes) obj;
		return this.getID() == other.getID();
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
