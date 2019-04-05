/**
 * 
 */
package wcadapter.clases;

/**
 * @author TIJUANA
 *
 */
public class Date_created {

	/**
	 * 
	 */
	 private  String date = "";
	 private  int timezone_type = 0;
	 private  String timezone = "";
	 
	 
	 public Date_created() {
		 super();
	 }
	 
	public Date_created(String date, int timezone_type, String timezone) {
		super();
		this.date = date;
		this.timezone_type = timezone_type;
		this.timezone = timezone;
	}
	public String getDate() {
		return date;
	}

	
	public int getTimezone_type() {
		return timezone_type;
	}
	public String getTimezone() {
		return timezone;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTimezone_type(int timezone_type) {
		this.timezone_type = timezone_type;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	 
	 
	

}
