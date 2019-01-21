package demo.Payless.model;

import java.util.Collection;

import javax.persistence.Entity;


@Entity
public class Purchase {

	
	private Collection<Product> products;

	
	
	public Purchase(){}
	
	public Purchase(Collection<Product> _products){
		this.products=_products;
	}
	
	public float totalPurchase(){
		return 0;
	}
	
	public void addProduct(Product e){
		this.products.add(e);
	}
	
	public void removeProduct(Product e){
		this.products.remove(e);
	}
	
	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	
	
	
}
