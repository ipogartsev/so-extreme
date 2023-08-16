package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ExtremeActivity;

public class ReadRecord {
	
	private Connection connection;
	private ResultSet result;
	private Long id;
	private ExtremeActivity activity = new ExtremeActivity();
	
	public ReadRecord(String dbName, String login, String password, Long id) {
		this.id = id;
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.connection = DriverManager.getConnection(url, login, password);
			} catch (ClassNotFoundException | SQLException e) {			
				e.printStackTrace();
			}		
	}
	
	public void dbRead() {
		String query = "SELECT * FROM activity WHERE activity_id = ?";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setLong(1, this.id);
			this.result = ps.executeQuery();
			this.result.next();
			activity.setId(this.result.getLong("activity_id"));
			activity.setName(this.result.getString("name"));
			activity.setDescription(this.result.getString("description"));
			activity.setImageUrl(this.result.getString("image_url"));
			activity.setPrice(this.result.getDouble("price"));
			activity.setSimulator(this.result.getBoolean("is_in_simulator"));
			activity.setDisabledAccessible(this.result.getBoolean("is_handicap_accessible"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ExtremeActivity getActivity() {
		return activity;
	}

}
