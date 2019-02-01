package demo.Payless.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="PRODUCT_ID",nullable=false)
	private long id;

	@Column(name="CODE",nullable=false)
	private String code;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="NAME",nullable=false)
	private String name;

	@Column(name="QUANTITY",nullable=false)
	private int quantity;

	@Column(name="PRICE_PRODUCT",nullable=false)
	private float priceUnit;

	@Column(name="STATE",nullable=false)
	private boolean state; 

/*	@OneToMany(mappedBy = "product",
			cascade = CascadeType.ALL,
			orphanRemoval = true )
	private List<StockProducts> stocks = new ArrayList<>();
*/
	//private Calification calification;


	public Product(){}


	public Product(String _code, String _desc, String _name, int _quantity , float _price){
		this.code=_code;
		this.description=_desc;
		this.name=_name;
		this.quantity=_quantity;
		this.priceUnit=_price;

	}



	/***************************************************************************************************************************************/	
	/*/*ANOTHER OPERATIONS METHODS*/



	/***************************************************************************************************************************************/	
	/*METODOS GETTER AND SETTER*/

	
/*	public List<StockProducts> getStocks() {
		return stocks;
	}


	public void setStocks(List<StockProducts> stocks) {
		this.stocks = stocks;
	}*/


	public long getId() {
		return id;
	}
	

	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public float getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(float priceUnit) {
		this.priceUnit = priceUnit;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isProduct(){
		return this.state;
	}


	
	
	
	/*
	public Calification getCalification() {
		return calification;
	}
	public void setCalification(Calification calification) {
		this.calification = calification;
	}

	 */



}
