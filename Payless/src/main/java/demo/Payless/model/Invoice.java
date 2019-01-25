package demo.Payless.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INVOICE_ID",nullable=false, unique=true )
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_INVOICE",nullable=false, unique=true )
	private Date dateInvoice;

	/*MAPEO POR JOIN TABLE ,CREANDO TABLA INTERMMEDA DE IDS DE AMBAS TABAS TABLA GENERADA INVOICE_PRODUCTS*/
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(
				name = "INVOICE_PRODUCTS",
				joinColumns = @JoinColumn(name = "INVOICE_ID"),
				inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
			   )
	private Collection<Product> products;

	@Column(name="TOTAL_INVOICE")
	private float totalInvoice;






	public Invoice(){
		this.products = new ArrayList<Product>();
	}


	
	/*Metodos para adicionar o remover products de un invoice*/
	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	
	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public Date getDateInvoice() {
		return dateInvoice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public void setDateInvoice(Date dateInvoice) {
		this.dateInvoice = dateInvoice;
	}


	public float getTotalInvoice() {
		return totalInvoice;
	}

	public void setTotalInvoice(float totalInvoice) {
		this.totalInvoice = totalInvoice;
	}





}



