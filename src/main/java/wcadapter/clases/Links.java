package wcadapter.clases;

import java.util.List;

public class Links {
	 private  List<Self> self;
	 private  List<Collection> collection;
	 private  List<Customer> customer;
	 
	 
	 
	public Links() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Links(List<Self> self, List<Collection> collection, List<Customer> customer) {
		super();
		this.self = self;
		this.collection = collection;
		this.customer = customer;
	}
	
	public void setSelf(List<Self> self) {
		this.self = self;
	}

	public void setCollection(List<Collection> collection) {
		this.collection = collection;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public List<Self> getSelf() {
		return self;
	}
	public List<Collection> getCollection() {
		return collection;
	}
	public List<Customer> getCustomer() {
		return customer;
	}

	 
	 
}
