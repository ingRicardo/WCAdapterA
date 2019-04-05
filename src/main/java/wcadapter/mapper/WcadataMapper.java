package wcadapter.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import wcadapter.clases.Wc_data;

public class WcadataMapper implements RowMapper<Wc_data>{

	
	@Override
	public Wc_data mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Wc_data wcdata = new Wc_data(rs.getInt("id"),
				rs.getString("ot_sur"), rs.getString("ot_rta") ,rs.getString("json"), rs.getString("status") );
		
		return wcdata;
	}
	
	
}
