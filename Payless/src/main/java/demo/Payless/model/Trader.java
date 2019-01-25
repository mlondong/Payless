package demo.Payless.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Trader extends Usser {

	@Column(name="CUIT",nullable=false,updatable=true)
	private long cuit;
	
	@Column(name="SCORE",nullable=false,updatable=true)
	private int score;
	
	
	//@ElementCollection
	//private Collection<Address> address;
	

	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(
			    name="TRADER_INVOICE", 
				joinColumns=@JoinColumn(name="USER_ID"),
				inverseJoinColumns=@JoinColumn(name="INVOICE_ID")
			    )
	private Collection<Invoice> invoices;
	
	
	
	
	
	
	public Trader(String _name, String _pass, long _cuit){
		super(_name, _pass);
		invoices= new ArrayList<Invoice>();
		this.cuit=_cuit;

	}
	
	public Trader(String _name, String _pass, long _cuit, Collection<Address> address){
		super(_name, _pass);
	//	address= new ArrayList<Address>();
		invoices= new ArrayList<Invoice>();
		this.cuit=_cuit;

		
	}
	
	/*************************************************************************************************************************************/	
	/*Otros metodos operacionales*/
	
	public void  addInvoice(Invoice i){
		this.invoices.add(i);
	}
	
	public void  removeInvoice(Invoice i){
		this.invoices.remove(i);
	}
	
	
	
	/*************************************************************************************************************************************/
	/*metodos setter and getter*/
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Collection<Invoice> invoices) {
		this.invoices = invoices;
	}

	

	
	
}
