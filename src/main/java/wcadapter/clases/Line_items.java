package wcadapter.clases;

import java.util.List;

public class Line_items {

 /*"id": 22,
      "name": "SAMPLE",
      "sku": "",
      "product_id": 173,
      "variation_id": 0,
      "quantity": 1,
      "tax_class": "",
      "price": "10.00",
      "subtotal": "10.00",
      "subtotal_tax": "0.00",
      "total": "10.00",
      "total_tax": "0.00",
      "taxes": [],
      "meta": [] 
  * */
	
	 private  long id;
	 private  String name;
	 private  String sku;
	 private  long product_id;
	 private  long variation_id;
	 private  long quantity;
	 private  String tax_class;
	 private  String price;
	 private  String subtotal;
	 private  String subtotal_tax;
	 private  String total;
	 private  String total_tax;
	 private  List<Tax> taxes;
	 private  List<Meta> meta;
	 
	 
	 
	 
	public Line_items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Line_items(long id, String name, String sku, long product_id, long variation_id, long quantity,
			String tax_class, String price, String subtotal, String subtotal_tax, String total, String total_tax,
			List<Tax> taxes, List<Meta> meta) {
		super();
		this.id = id;
		this.name = name;
		this.sku = sku;
		this.product_id = product_id;
		this.variation_id = variation_id;
		this.quantity = quantity;
		this.tax_class = tax_class;
		this.price = price;
		this.subtotal = subtotal;
		this.subtotal_tax = subtotal_tax;
		this.total = total;
		this.total_tax = total_tax;
		this.taxes = taxes;
		this.meta = meta;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSku() {
		return sku;
	}
	public long getProduct_id() {
		return product_id;
	}
	public long getVariation_id() {
		return variation_id;
	}
	public long getQuantity() {
		return quantity;
	}
	public String getTax_class() {
		return tax_class;
	}
	public String getPrice() {
		return price;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public String getSubtotal_tax() {
		return subtotal_tax;
	}
	public String getTotal() {
		return total;
	}
	public String getTotal_tax() {
		return total_tax;
	}
	public List<Tax> getTaxes() {
		return taxes;
	}
	public List<Meta> getMeta() {
		return meta;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public void setVariation_id(long variation_id) {
		this.variation_id = variation_id;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public void setTax_class(String tax_class) {
		this.tax_class = tax_class;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public void setSubtotal_tax(String subtotal_tax) {
		this.subtotal_tax = subtotal_tax;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public void setTotal_tax(String total_tax) {
		this.total_tax = total_tax;
	}
	public void setTaxes(List<Tax> taxes) {
		this.taxes = taxes;
	}
	public void setMeta(List<Meta> meta) {
		this.meta = meta;
	}
	 
	 
}
