package demo.Payless.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/* 
 * Clase Abstracta User
 * se usa estrategia InheritanceType.JOINED para mapeo de Herencia
 * 
 * */



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Usser {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID",nullable=false,updatable=false)
	private long id;

	@Column(name="NAME",nullable=false,updatable=true)
	private String name;
	
	@Column(name="PASSWORD", nullable=false,updatable=true)
	private String password;
	
	@Column(name="STATE", updatable=true)
	private boolean state;
	
	
	public Usser(){}
	
	public Usser(String _name, String _pass){
		this.name=_name;
		this.password=_pass;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
	
}
