package demo.Payless.model;

import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

public class DetailPurchase {
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private Purchase purchase;

}
