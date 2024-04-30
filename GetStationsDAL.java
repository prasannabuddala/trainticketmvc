package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetStationsDAL {
	private List<Stations> stations = new ArrayList<>();
	private List<Trains> trains = new ArrayList<>();
	Connection cn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	public GetStationsDAL() {
		try {
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin",
					"pff123");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Stations> getStations() {
		try {
			st = cn.createStatement();
			String query = "select * from stations_pr";
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("st_id");
				String name = rs.getString("st_name");
				String code = rs.getString("st_code");
				Stations station = new Stations(id, name, code);
				// System.out.println("station " + station);
				stations.add(station);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return stations;
	}

	public List<Trains> getTrains(String fromStation, String toStation) {
		String query = "SELECT DISTINCT t.tr_id, t.tr_name FROM trains_pr t "
				+ "JOIN trainstations_pr ts1 ON t.tr_id = ts1.tr_id JOIN trainstations_pr ts2 ON t.tr_id = ts2.tr_id "
				+ "JOIN stations_pr s1 ON ts1.st_code = s1.st_code JOIN stations_pr s2 ON ts2.st_code = s2.st_code "
				+ "WHERE s1.st_name = ? AND s2.st_name = ? AND ts1.tr_index < ts2.tr_index;";
		System.out.println(fromStation + " " + toStation);
		try {
			pst = cn.prepareStatement(query);
			pst.setString(1, fromStation);
			pst.setString(2, toStation);
			if (rs != null && !rs.isClosed())
				rs.close();
			rs = pst.executeQuery();
			while (rs.next()) {
				int trid = rs.getInt("tr_id");
				String tname = rs.getString("tr_name");
				Trains train = new Trains(trid, tname);
				trains.add(train);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return trains;
	}
}
