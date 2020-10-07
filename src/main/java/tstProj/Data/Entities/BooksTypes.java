package tstProj.Data.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "BooksTypes")
@XmlRootElement
public class BooksTypes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 274658246293333755L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer ID;
	
	@Column(name = "typeName")
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
        return ID.hashCode();
	}
}
