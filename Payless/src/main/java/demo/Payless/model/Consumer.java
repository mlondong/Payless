package demo.Payless.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
public class Consumer extends Usser {

	@Column(name="DNI",nullable=false,updatable=true)
	private long dni;
	
	@Column(name="FIRSTNAME",nullable=false,updatable=true)
	private String firstName;
	
	@Column(name="LASTNAME",nullable=false,updatable=true)
	private String lastName;
	
	//@OneToMany
	//private Collection<Purchase> purchase;
	
	//@Embedded
	//private FamillyShopingBasket familyBasket;
	
	
	
	public Consumer(){}
	
	public Consumer(String _name, String _pass, long _dni, String _firstName, String _lastName  ){
		super(_name, _pass);
		this.dni=_dni;
		this.firstName=_firstName;
		this.lastName=_lastName;
	}
	
	
	//Metodos Gter and Setter
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/*public Collection<Purchase> getCompras() {
		//return purchase;
	}
	public void setCompras(Collection<Purchase> compras) {
		//this.purchase = compras;
	}
	public FamillyShopingBasket getCanastaFamiliar() {
		//return familyBasket;
	}
	public void setCanastaFamiliar(FamillyShopingBasket canastaFamiliar) {
		//this.familyBasket = canastaFamiliar;
	}*/
	
	
	
	
	
	
	
}
