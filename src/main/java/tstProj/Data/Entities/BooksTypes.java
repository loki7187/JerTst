package tstProj.Data.Entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class BooksTypes {
	
	private @Id @GeneratedValue long ID;
	private String typeName;

	private BooksTypes() {
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
}
