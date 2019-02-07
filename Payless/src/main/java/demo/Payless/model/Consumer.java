package demo.Payless.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
public class Consumer extends Usser {

	@Column(name="DNI",nullable=false)
	private long dni;
	
	@Column(name="FIRSTNAME",nullable=false)
	private String firstName;
	
	@Column(name="LASTNAME",nullable=false)
	private String lastName;
	
	
	/*MAPEO DE PURCHASE EN CONSUMER DE 1 A MUCHOS*/
/*	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(
			name="CONSUMER_PURCHASE" , 
			joinColumns=@JoinColumn(name="USER_ID"),
			inverseJoinColumns=@JoinColumn(name="PURCHASE_ID") 
			)
	private Collection<Purchase> purchase;
*/
	
	

	
	
	
	
	
/***************************************************************************************************************************************/	
	
	public Consumer(){}
	
	public Consumer(String _name, String _pass, long _dni, String _firstName, String _lastName  ){
		super(_name, _pass);
		//purchase = new ArrayList<Purchase>();
		this.dni=_dni;
		this.firstName=_firstName;
		this.lastName=_lastName;
	}
	
	
/***************************************************************************************************************************************/	
	//ANOTHER OPERATIONS
	
	
	/*public boolean findPurchase(Purchase compra){
		return this.getPurchase().contains(compra);	
	}*/

	
	
	
	
	/***************************************************************************************************************************************/
	
	//Metodos Gter and Setter
	
	
	//public Collection<Purchase> getPurchase() {
	//	return purchase;
	//}

	public void setPurchase(Collection<Purchase> purchase) {
	//	this.purchase = purchase;
	}

	
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

	@Override
	public String toString() {
		return "Consumer [dni=" + dni + ", firstName=" + firstName + ", lastName=" + lastName; 
	}

	
	

	



	
	
	
	
}
