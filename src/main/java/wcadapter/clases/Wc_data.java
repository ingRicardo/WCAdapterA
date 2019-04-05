package wcadapter.clases;

public class Wc_data {

	private final int id;
	private final String ot_sur;
	private final String ot_rta;
	private final String json;
	private final String status;

	public Wc_data(int id, String ot_sur, String ot_rta, String json, String status) {
		super();
		this.id = id;
		this.ot_sur = ot_sur;
		this.ot_rta = ot_rta;
		this.json = json;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public int getId() {
		return id;
	}
	public String getOt_sur() {
		return ot_sur;
	}
	public String getOt_rta() {
		return ot_rta;
	}
	public String getJson() {
		return json;
	}
	
	
}
