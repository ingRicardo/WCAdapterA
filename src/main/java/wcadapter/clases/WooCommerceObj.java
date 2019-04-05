package wcadapter.clases;

import java.util.List;

public class WooCommerceObj {
	
	 private long id =0;
	 private long parent_id = 0;
	 private String status = "";
	 private String order_key = "";	 
	 private String number = "";
	 
	 private String currency = "";
	 private String version = "";
	 
	 private boolean prices_include_tax= false;
	 private  String dates_created;
	 
	 private Date_created date_created = null; 
	 private Date_modified date_modified = null;
	 private  String dates_modified;
	 
	 private long customer_id =0;
	 private String discount_total="";
	 private String discount_tax = "";
	 private String shipping_total = "";
	 private String shipping_tax ="";
	 private String cart_tax = "";
	 private String total ="";
	 private String total_tax="";
	 private Billing billing = null;
	 private Shipping shipping = null;
	 private String payment_method = "";
	 private String payment_method_title = "";
	 private String transaction_id = "";
	 private String customer_ip_address = "";
	 private String customer_user_agent = "";
	 
	 private String created_via = "";
	 private String customer_note = "";
	 private String date_completed = "";
	 private String date_paid = "";
	 private String cart_hash = "";
	 private List<Line_items> line_items = null;
	 private  Line_items line_item = null;
	 
	 private List<Tax_lines> tax_lines = null;
	 
	 private Tax_lines tax_line = null;
	 
	 private List<Shipping_lines> shipping_lines = null;
	 
	 private Shipping_lines shipping_line = null;
	 
	 private List<Fee_lines> fee_lines = null;
	 
	 private Fee_lines fee_line = null;
	 
	 private List<Coupon_lines> coupon_lines =  null;
	 
	 private Coupon_lines coupon_line =  null;
	 
	 private List<Refunds> refunds =  null;
	 
	 private Refunds refund =  null;
	 private Links _links =  null;
	 
	 private Meta_data metadata = null;
	 
     
   

	public WooCommerceObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public void setDates_created(String dates_created) {
		this.dates_created = dates_created;
	}




	public void setDates_modified(String dates_modified) {
		this.dates_modified = dates_modified;
	}




	public String getDates_created() {
		return dates_created;
	}




	public String getDates_modified() {
		return dates_modified;
	}




	public Meta_data getMetadata() {
		return metadata;
	}




	public void setMetadata(Meta_data metadata) {
		this.metadata = metadata;
	}




	public Fee_lines getFee_line() {
		return fee_line;
	}




	public void setFee_line(Fee_lines fee_line) {
		this.fee_line = fee_line;
	}




	public Coupon_lines getCoupon_line() {
		return coupon_line;
	}




	public void setCoupon_line(Coupon_lines coupon_line) {
		this.coupon_line = coupon_line;
	}




	public Refunds getRefund() {
		return refund;
	}




	public void setRefund(Refunds refund) {
		this.refund = refund;
	}




	public Tax_lines getTax_line() {
		return tax_line;
	}




	public void setTax_line(Tax_lines tax_line) {
		this.tax_line = tax_line;
	}




	public Shipping_lines getShipping_line() {
		return shipping_line;
	}




	public void setShipping_line(Shipping_lines shipping_line) {
		this.shipping_line = shipping_line;
	}




	public WooCommerceObj(long id, long parent_id, String status, String order_key, String number, String currency,
			String version, boolean prices_include_tax, Date_created date_created, Date_modified date_modified,
			long customer_id, String discount_total, String discount_tax, String shipping_total, String shipping_tax,
			String cart_tax, String total, String total_tax, Billing billing, Shipping shipping, String payment_method,
			String payment_method_title, String transaction_id, String customer_ip_address, String customer_user_agent,
			String created_via, String customer_note, String date_completed, String date_paid, String cart_hash,
			List<Line_items> line_items, List<Tax_lines> tax_lines, List<Shipping_lines> shipping_lines,
			List<Fee_lines> fee_lines, List<Coupon_lines> coupon_lines, List<Refunds> refunds, Links _links) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.status = status;
		this.order_key = order_key;
		this.number = number;
		this.currency = currency;
		this.version = version;
		this.prices_include_tax = prices_include_tax;
		this.date_created = date_created;
		this.date_modified = date_modified;
		this.customer_id = customer_id;
		this.discount_total = discount_total;
		this.discount_tax = discount_tax;
		this.shipping_total = shipping_total;
		this.shipping_tax = shipping_tax;
		this.cart_tax = cart_tax;
		this.total = total;
		this.total_tax = total_tax;
		this.billing = billing;
		this.shipping = shipping;
		this.payment_method = payment_method;
		this.payment_method_title = payment_method_title;
		this.transaction_id = transaction_id;
		this.customer_ip_address = customer_ip_address;
		this.customer_user_agent = customer_user_agent;
		this.created_via = created_via;
		this.customer_note = customer_note;
		this.date_completed = date_completed;
		this.date_paid = date_paid;
		this.cart_hash = cart_hash;
		this.line_items = line_items;
		this.tax_lines = tax_lines;
		this.shipping_lines = shipping_lines;
		this.fee_lines = fee_lines;
		this.coupon_lines = coupon_lines;
		this.refunds = refunds;
		this._links = _links;
	}

  
	
	
	public Line_items getLine_item() {
		return line_item;
	}




	public void setLine_item(Line_items line_item) {
		this.line_item = line_item;
	}




	public Date_modified getDate_modified() {
		return date_modified;
	}


	public Date_created getDate_created() {
		return date_created;
	}


	public String getShipping_tax() {
		return shipping_tax;
	}
	public long getId() {
		return id;
	}
	public long getParent_id() {
		return parent_id;
	}
	public String getStatus() {
		return status;
	}
	public String getOrder_key() {
		return order_key;
	}
	public String getNumber() {
		return number;
	}
	public String getCurrency() {
		return currency;
	}
	public String getVersion() {
		return version;
	}
	public boolean isPrices_include_tax() {
		return prices_include_tax;
	}
	/*public String getDate_created() {
		return date_created;
	}*/
	/*public String getDate_modified() {
		return date_modified;
	}*/
	public long getCustomer_id() {
		return customer_id;
	}
	public String getDiscount_total() {
		return discount_total;
	}
	public String getDiscount_tax() {
		return discount_tax;
	}
	public String getShipping_total() {
		return shipping_total;
	}
	public String getCart_tax() {
		return cart_tax;
	}
	public String getTotal() {
		return total;
	}
	public String getTotal_tax() {
		return total_tax;
	}
	public Billing getBilling() {
		return billing;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public String getPayment_method_title() {
		return payment_method_title;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public String getCustomer_ip_address() {
		return customer_ip_address;
	}
	public String getCustomer_user_agent() {
		return customer_user_agent;
	}
	public String getCreated_via() {
		return created_via;
	}
	public String getCustomer_note() {
		return customer_note;
	}
	public String getDate_completed() {
		return date_completed;
	}
	public String getDate_paid() {
		return date_paid;
	}
	public String getCart_hash() {
		return cart_hash;
	}
	public List<Line_items> getLine_items() {
		return line_items;
	}
	public List<Tax_lines> getTax_lines() {
		return tax_lines;
	}
	public List<Shipping_lines> getShipping_lines() {
		return shipping_lines;
	}
	public List<Fee_lines> getFee_lines() {
		return fee_lines;
	}
	public List<Coupon_lines> getCoupon_lines() {
		return coupon_lines;
	}
	public List<Refunds> getRefunds() {
		return refunds;
	}
	public Links get_links() {
		return _links;
	}




	public void setId(long id) {
		this.id = id;
	}




	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public void setOrder_key(String order_key) {
		this.order_key = order_key;
	}




	public void setNumber(String number) {
		this.number = number;
	}




	public void setCurrency(String currency) {
		this.currency = currency;
	}




	public void setVersion(String version) {
		this.version = version;
	}




	public void setPrices_include_tax(boolean prices_include_tax) {
		this.prices_include_tax = prices_include_tax;
	}




	public void setDate_created(Date_created date_created) {
		this.date_created = date_created;
	}




	public void setDate_modified(Date_modified date_modified) {
		this.date_modified = date_modified;
	}




	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}




	public void setDiscount_total(String discount_total) {
		this.discount_total = discount_total;
	}




	public void setDiscount_tax(String discount_tax) {
		this.discount_tax = discount_tax;
	}




	public void setShipping_total(String shipping_total) {
		this.shipping_total = shipping_total;
	}




	public void setShipping_tax(String shipping_tax) {
		this.shipping_tax = shipping_tax;
	}




	public void setCart_tax(String cart_tax) {
		this.cart_tax = cart_tax;
	}




	public void setTotal(String total) {
		this.total = total;
	}




	public void setTotal_tax(String total_tax) {
		this.total_tax = total_tax;
	}




	public void setBilling(Billing billing) {
		this.billing = billing;
	}




	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}




	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}




	public void setPayment_method_title(String payment_method_title) {
		this.payment_method_title = payment_method_title;
	}




	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}




	public void setCustomer_ip_address(String customer_ip_address) {
		this.customer_ip_address = customer_ip_address;
	}




	public void setCustomer_user_agent(String customer_user_agent) {
		this.customer_user_agent = customer_user_agent;
	}




	public void setCreated_via(String created_via) {
		this.created_via = created_via;
	}




	public void setCustomer_note(String customer_note) {
		this.customer_note = customer_note;
	}




	public void setDate_completed(String date_completed) {
		this.date_completed = date_completed;
	}




	public void setDate_paid(String date_paid) {
		this.date_paid = date_paid;
	}




	public void setCart_hash(String cart_hash) {
		this.cart_hash = cart_hash;
	}




	public void setLine_items(List<Line_items> line_items) {
		this.line_items = line_items;
	}




	public void setTax_lines(List<Tax_lines> tax_lines) {
		this.tax_lines = tax_lines;
	}




	public void setShipping_lines(List<Shipping_lines> shipping_lines) {
		this.shipping_lines = shipping_lines;
	}




	public void setFee_lines(List<Fee_lines> fee_lines) {
		this.fee_lines = fee_lines;
	}




	public void setCoupon_lines(List<Coupon_lines> coupon_lines) {
		this.coupon_lines = coupon_lines;
	}




	public void setRefunds(List<Refunds> refunds) {
		this.refunds = refunds;
	}




	public void set_links(Links _links) {
		this._links = _links;
	}
	
	 
	
	 
	 
}
