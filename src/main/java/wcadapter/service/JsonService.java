package wcadapter.service;

import java.sql.SQLException;
import java.util.List;

import wcadapter.clases.Wc_data;

public interface JsonService {

	
	public String insertJsonObj(String ot_sur,String ot_rta, String g, String status) throws SQLException;
	
	public List<Wc_data> getAlldata();
	
	public String getJson(int id);
	public String getJsonOT(int id);
}
