package demo.Payless.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Purchase {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="PURCHASE_ID")
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CREATION")
	private Date dateCreation;

	@Column(name="NUM_INVOICE")
	private long numInvoice;


	/*MAPEO de PRODUCT CON TABLA INTERMEDIA*/
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(
				name="PURCHASE_PRODUCT" , 
				joinColumns=@JoinColumn(name="PURCHASE_ID"),
				inverseJoinColumns=@JoinColumn(name="PRODUCT_ID") 
			  )
	private Collection<Product> products;


	//@OneToOne(fetch = FetchType.LAZY)
	//private DetailPurchase detailPurchase;




	public Purchase(){	}

	public Purchase(Date date, long numInv){
		products =new ArrayList<Product>();;
		this.dateCreation=date;
		this.numInvoice=numInv;
	}

	/***************************************************************************************************************************************/	

		
	//METODOS OPERACIONALES
	public void addProduct(Product p){
		this.products.add(p);
	}

	public void removeProduct(Product p){
		this.products.remove(p);
	}


	/***************************************************************************************************************************************/	
	//SETTER AND GETTERS
	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", dateCreation=" + dateCreation + ", numInvoice="
				+ numInvoice + "]";
	}








}
