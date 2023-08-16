package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;


public class DBFactory {

	public DataSource getMysqlDataSource() {
		Properties props = new Properties();
		FileInputStream fileInputStream = null;
		MysqlDataSource baseDataSource = null;
		try {
			fileInputStream = new FileInputStream("db.properties");
			props.load(fileInputStream);
			baseDataSource = new MysqlDataSource();
			baseDataSource.setURL(props.getProperty("MYSQL_DB_URL"));
			baseDataSource.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			baseDataSource.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baseDataSource;
	}

}
