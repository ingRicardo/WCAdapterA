package wcadapter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {

	
	@Bean(name = "dsMysql")
	public static DataSource dataSource() {
	    return DataSourceBuilder
	        .create()
	        .username("hitss")
	        .password("ziztemaz")
	        .url("jdbc:mariadb://10.168.23.193:3306/test")
	        .driverClassName("org.mariadb.jdbc.Driver")
	        .build();
	} 
	 
	@Primary
	@Bean(name = "jdbcMysql")
    @Autowired
    public JdbcTemplate slaveJdbcTemplate(@Qualifier("dsMysql") DataSource dsMysql) {
        return new JdbcTemplate(dsMysql);
    }
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
