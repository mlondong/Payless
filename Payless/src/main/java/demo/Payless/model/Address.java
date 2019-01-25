package demo.Payless.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private long id;
	private String description;
	private int city;
}
