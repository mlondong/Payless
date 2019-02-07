package demo.Payless.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PURCHASE_ID")
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CREATION")
	private Date dateCreation;

	@Column(name="NUM_INVOICE")
	private long numInvoice;


	/*MAPEO de PRODUCT CON TABLA INTERMEDIA PURCHASE_PRODUCT, PERO ESTA ESTRATEGIA SOLO FUNCIONA CON UN SOLO PRODUCTO SIN REPETIR POR CADA
	 * PURCHASE ES DECIR UN CLIENTE PUEDE TENER MUCHAS COMPRAS PERO EN CADA COMPRA NO PODRA REPETIR PRODUCTOS LO CUAL NO SIRVE*/
	/*@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(
				name="PURCHASE_PRODUCT" , 
				joinColumns=@JoinColumn(name="PURCHASE_ID"),
				inverseJoinColumns=@JoinColumn(name="PRODUCT_ID") 
			  )
	private Collection<Product> products;*/
	
	/*
	@OneToMany(mappedBy="purchase", 
			   cascade=CascadeType.ALL,
			   orphanRemoval=true)
	private Collection<PurchaseProducts> purchasesprod;
	*/

	/*@OneToOne(fetch = FetchType.LAZY,orphanRemoval=true,optional=false)
	@JoinColumn(name = "USER_ID")	
	private Consumer consumer;
	*/
	
	//@OneToOne(fetch = FetchType.LAZY)
	//private DetailPurchase detailPurchase;




	public Purchase(){	}

	public Purchase(Date date, long numInv){
		//this.purchasesprod = new ArrayList<PurchaseProducts>();
		this.dateCreation=date;
		this.numInvoice=numInv;
	}

	/***************************************************************************************************************************************/	
	/*metodos operacionales*/
	
	/*ESTE METODO REEMPLAZA A LA COLLECION DE StockProducts EN LA CLASE PRODUCT,  DEJANDOLO SINGLE SIDE BIDIRECCIONAL, asi mismo
	 * USA EL METODO REMOVE ABAJO DESCRITO PARA REMOVER LOS STOCKPRODUCTS CON SU PRODUCTO ejemplo tomado de
	 * https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/*/
	
	/*public void addProduct(Product product, int quantity){
		PurchaseProducts pprod = new PurchaseProducts(this,product, quantity);
		purchasesprod.add(pprod);
	}*/
	
	/*public void removeProduct(Product p){
		 for (Iterator<PurchaseProducts> iterator = products.iterator(); iterator.hasNext(); ) {
			 PurchaseProducts stockproducs = iterator.next();
		 
		        if (stockproducs.getProduct().equals(this) && stockproducs.getStock().equals(p)) {
		            iterator.remove();
		            stockproducs.setProduct(null);
		            stockproducs.setStock(null);
		        }
		 }
  
	}
	*/
		
	
	
	/***************************************************************************************************************************************/	
	//SETTER AND GETTERS
	

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

	
	public long getNumInvoice() {
		return numInvoice;
	}

	public void setNumInvoice(long numInvoice) {
		this.numInvoice = numInvoice;
	}



	








}
