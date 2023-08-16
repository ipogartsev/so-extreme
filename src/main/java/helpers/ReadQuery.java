package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.ExtremeActivity;

public class ReadQuery {

	private Connection connection;
	private ResultSet result;

	

	public ReadQuery(String dbName, String login, String password) {
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, login, password);
			System.out.println("database connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void dbRead() {
		String query = "select * from activity";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.result = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getHTMLTable() {
		String table = "";
		table += "<table border=1>";
		table += "<tr>";
		table += "<td>id</td><td>name</td><td>description</td><td>image URL</td><td>price</td><td>simulator</td><td>handicap access</td><td>action</td>";
		table += "</tr>";

		try {
			while (this.result.next()) {
				ExtremeActivity activity = new ExtremeActivity();
				activity.setId(this.result.getLong("activity_id"));
				activity.setName(this.result.getString("name"));
				activity.setDescription(this.result.getString("description"));
				activity.setImageUrl(this.result.getString("image_url"));
				activity.setPrice(this.result.getDouble("price"));
				activity.setSimulator(this.result.getBoolean("is_in_simulator"));
				activity.setDisabledAccessible(this.result.getBoolean("is_handicap_accessible"));
				// System.out.println(activity.toString());

				table += "<tr>";
				table += "<td>";
				table += activity.getId();
				table += "</td>";
				table += "<td>";
				table += activity.getName();
				table += "</td>";
				table += "<td>";
				table += activity.getDescription();
				table += "</td>";
				table += "<td>";
				table += activity.getImageUrl();
				table += "</td>";
				table += "<td>";
				table += activity.getPrice();
				table += "</td>";
				table += "<td>";
				table += activity.isSimulator();
				table += "</td>";
				table += "<td>";
				table += activity.isDisabledAccessible();
				table += "</td>";
				table += "<td>";
				table += "<a href=update?activityId=" + activity.getId() + "> update </a>"
						+ "<a href=delete?activityId=" + activity.getId() + "> delete </a>";
				table += "</td>";
				table += "</tr>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		table += "</table>";
		return table;
	}
}
