package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ExtremeActivity;

public class UpdateQuery {
	
	private Connection connection;
		
	public UpdateQuery(String dbName, String login, String password) {
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, login, password);			
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateActivity(ExtremeActivity activity) {
		
		String query = "UPDATE activity SET name = ?, description = ?, image_url =?, price = ?, is_in_simulator = ?, is_handicap_accessible = ? WHERE activity_id = ?";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setString(1, activity.getName());
			ps.setString(2, activity.getDescription());
			ps.setString(3, activity.getImageUrl());
			ps.setDouble(4, activity.getPrice());
			ps.setBoolean(5, activity.isSimulator());
			ps.setBoolean(6, activity.isDisabledAccessible());
			ps.setLong(7, activity.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
