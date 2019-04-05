package wcadapter.clases;

public class Billing {
	
	private  String first_name;
	private  String last_name;
	private  String company;
	private  String address_1;
	private  String address_2;
	private  String city;
	private  String state;
	private  String postcode;
	private  String country;
	private  String email;
	private  String phone;
	/*"last_name": "rodriguez",
    "company": "",
    "address_1": "416 w. San Ysidro Blvd.",
    "address_2": "ste. L - 1",
    "city": "san ysidro",
    "state": "CA",
    "postcode": "92173",
    "country": "US",
    "email": "huertag@globalhitss.com",
    "phone": "6197049434" 
	 * */
	
	
	
	public Billing(String first_name, String last_name, String company, String address_1, String address_2, String city,
			String state, String postcode, String country, String email, String phone) {
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
		this.email = email;
		this.phone = phone;
	}
	
	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCompany() {
		return company;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
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
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	
	
	
	

}
