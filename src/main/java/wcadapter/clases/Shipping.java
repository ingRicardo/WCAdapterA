package wcadapter.clases;

public class Shipping {

	/*    "first_name": "",
    "last_name": "",
    "company": "",
    "address_1": "",
    "address_2": "",
    "city": "",
    "state": "",
    "postcode": "",
    "country": "" 
	 * */
	private  String first_name;
	private  String last_name;
	private  String company;
	private  String address_1;
	private  String address_2;
	private  String city;
	private  String state;
	private  String postcode;
	private  String country;
	
	
	
	
	public Shipping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shipping(String first_name, String last_name, String company, String address_1, String address_2,
			String city, String state, String postcode, String country) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.company = company;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.country = country;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress_1() {
		return address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
