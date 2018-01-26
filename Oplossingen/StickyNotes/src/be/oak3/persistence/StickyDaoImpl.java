package be.oak3.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import be.oak3.model.StickyBean;

public class StickyDaoImpl implements StickyDao {

	// Context.xml in tomcat folder zelf invullen.
	private DataSource ds;

	public StickyDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<StickyBean> getAllStickies() throws SQLException {
		List<StickyBean> stickies = new ArrayList<>();
		String sql = "select * from note;";
		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				StickyBean bean = new StickyBean();
				bean.setText(rs.getString("text"));
				stickies.add(bean);
			}
		}
		return stickies;
	}

	@Override
	public int deleteStickyById(int id) throws SQLException {
		String sql = "DELETE FROM note where id=?";
		int result = 0;
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		}
		return result;
	}

	@Override
	public int addSticky(String text) throws SQLException {
		String sql = "INSERT INTO note (text) VALUES(?);";
		int result = 0;
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, text);
			result = stmt.executeUpdate();
		}
		return result;
	}

	// Met Datasource wordt dit niet meer gebruikt.
	private Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver not found: " + e);
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sticky?useSSL=false", "root", "root");
	}

	@Override
	public int deleteAllStickies() throws SQLException {
		String sql = "Delete from note;";
		int result = 0;
		try (Connection con = getConnection(); Statement stmt = con.createStatement();) {
			result = stmt.executeUpdate(sql);
		}
		return result;
	}

	@Override
	public StickyBean getStickyByValue(String text) throws SQLException {
		String sql = "SELECT * from note where text =?;";
		StickyBean bean = new StickyBean();
		try (Connection con = ds.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, text);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				bean.setText(rs.getString("text"));
				bean.setId(rs.getInt("id"));
			}
		}
		return bean;
	}
}
