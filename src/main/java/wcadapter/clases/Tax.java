package wcadapter.clases;

import java.util.List;

public class Tax {
	 private  List<Tax> taxes;

	 
	 
	public Tax() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setTaxes(List<Tax> taxes) {
		this.taxes = taxes;
	}

	public Tax(List<Tax> taxes) {
		super();
		this.taxes = taxes;
	}

	public List<Tax> getTaxes() {
		return taxes;
	}

	

}
