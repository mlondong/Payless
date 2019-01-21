package demo.Payless.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Trader extends Usser {

	@Column(name="CUIT",nullable=false,updatable=true)
	private long cuit;
	
	@Column(name="SCORE",nullable=false,updatable=true)
	private int score;
	
	//@OneToMany
	//private Collection<Product> product;
	
	
	public Trader(){}
	
	public Trader(String _name, String _pass, long _cuit){
		super(_name, _pass);
		this.cuit=_cuit;
	}
	
	
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
	
	/*public Collection<Product> getProduct() {
		return product;
	}
	public void setProduct(Collection<Product> product) {
		this.product = product;
	}*/
	
	
}
