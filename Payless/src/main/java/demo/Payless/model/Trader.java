package demo.Payless.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Trader extends Usser {

	@Column(name="CUIT",nullable=false,updatable=true)
	private long cuit;
	
	
	@Column(name="SCORE",nullable=false,updatable=true)
	private int score;
	

	/*SE CREA UN SOLO STOCK POR TRADER Y SE AGREGAR PRODUCTOS AL STOCK*/
	@OneToOne(mappedBy="trader",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private Stock stock;
	
	
	/*SE CREAN INVOICES CON UNA TABLA INTERMEDIA TRADER_INVOICE QUE CONTIENE MUCHOS TRADERS*/
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(
			    name="TRADER_INVOICE", 
				joinColumns=@JoinColumn(name="USER_ID"),
				inverseJoinColumns=@JoinColumn(name="INVOICE_ID")
			    )
	private Collection<Invoice> invoices;
	

	
	
	//@ElementCollection
	//private Collection<Address> address;

	
	
	
	
	public Trader(){}
	
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
	/*METODOS ADD REMOVE Y CREAATE STOCK EN TRADER*/
	public void createStock(){
		this.stock = new  Stock();
		this.stock.setDateStock(new Date());
		this.stock.setTrader(this);
	}
	
	public void addStockProducts(Product p, int quantity){
		this.stock.addProduct(p, quantity);
	}
	
	public void removeStockProducts(Product p){
		this.stock.removeProduct(p);
	}

	
	
	
	/*METODOS DE ADD INVOIDE REMOVE INVOICE*/
	
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
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
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

	@Override
	public String toString() {
		return "Trader [cuit=" + cuit + ", score=" + score + ", stock=" + stock + ", Invoice" + invoices;
				
	}

	

	
	
}
