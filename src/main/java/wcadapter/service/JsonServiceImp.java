/**
 * 
 */
package wcadapter.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import wcadapter.clases.Wc_data;


/**
 * @author TIJUANA
 *
 */
@Service
public class JsonServiceImp implements JsonService{
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	 public JsonServiceImp(JdbcTemplate jdbcTemplate) {
		  this.jdbcTemplate = jdbcTemplate;
	    }
	
	
	@Override
	public String insertJsonObj(String ot_sur,String ot_rta , String g, String status) throws SQLException {
		String sql = "", msg ="OK";
		
		sql ="INSERT INTO wo_data( ot_sur,ot_rta,json, status)VALUES(?,?,?,?)";
		/*
		Gson gson = new GsonBuilder().create();
		String jsonObject = gson.toJson(g);
		*/
		
		jdbcTemplate.update(sql ,new Object[] {
				ot_sur,
				ot_rta,
				g.toString(),
				status
				} );
		
		
	//	jdbcTemplate.getDataSource().getConnection().close();
		return msg;
	}
	
	public String getJson(int id) {
		
		String sql = "SELECT json FROM wo_data WHERE id = ?";
	/*	Wc_data wcdata = jdbcTemplate.queryForObject(
		    query, new Object[] { id }, new WcadataMapper());
		
		Wc_data wcdataobj =  new Wc_data(wcdata.getId(),wcdata.getOt_sur(),wcdata.getOt_rta(), wcdata.getJson()
				, wcdata.getStatus());
		*/
		 String json = (String) jdbcTemplate.queryForObject(
		            sql, new Object[] { id }, String.class);
		
		
			
		return json;
	}
	
	
	public String getJsonOT(int id) {
		
		String sql = "SELECT json FROM wo_data WHERE ot_rta = ?";
	/*	Wc_data wcdata = jdbcTemplate.queryForObject(
		    query, new Object[] { id }, new WcadataMapper());
		
		Wc_data wcdataobj =  new Wc_data(wcdata.getId(),wcdata.getOt_sur(),wcdata.getOt_rta(), wcdata.getJson()
				, wcdata.getStatus());
		*/
		 String json = (String) jdbcTemplate.queryForObject(
		            sql, new Object[] { id }, String.class);
		
		
			
		return json;
	}
	

	public List<Wc_data> getAlldata(){
		
		String sql = "select * from wo_data";
		
		RowMapper<Wc_data> rowMapper = new RowMapper<Wc_data>() {
			
			@Override
			public Wc_data mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Wc_data wcdata = new Wc_data(rs.getInt("id"),
						rs.getString("ot_sur"), rs.getString("ot_rta") ,rs.getString("json"), rs.getString("status") );
				
				return wcdata;
			}
		};
		
		return this.jdbcTemplate.query(sql, rowMapper); 
	}
	
}
