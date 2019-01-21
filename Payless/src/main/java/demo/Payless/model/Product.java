package demo.Payless.model;

public abstract class Product {

	
	private long id;
	private String code;
	private String description;
	private String name;
	private int quantity;
	private float priceUnit;
	private Calification calification;
	private boolean state; 
	
	public Product(){}
	
	public Product(String _code, String _desc, String _name, int _quantity , float _price){
		this.code=_code;
		this.description=_desc;
		this.name=_name;
		this.quantity=_quantity;
		this.priceUnit=_price;
	}
	
	
	
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


	public Calification getCalification() {
		return calification;
	}
	public void setCalification(Calification calification) {
		this.calification = calification;
	}

	
	
	
	
}
