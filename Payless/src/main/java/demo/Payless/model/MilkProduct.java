package demo.Payless.model;

import javax.persistence.Entity;

@Entity
public class MilkProduct extends Product {

	public MilkProduct(){}
	
	public MilkProduct(String _code, String _desc, String _name, int _quantity, float _price) {
		super(_code, _desc, _name, _quantity, _price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MilkProduct [  getId()=" + getId() + ", getCode()=" + getCode()
				+ ", getDescription()=" + getDescription() + ", getName()=" + getName() + ", getQuantity()="
				+ getQuantity() + ", getPriceUnit()=" + getPriceUnit() + "]";
	}

	
	

}
